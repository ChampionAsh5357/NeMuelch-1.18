package net.shirojr.nemuelch.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.shirojr.nemuelch.NeMuelch;
import net.shirojr.nemuelch.NeMuelchClient;

import java.util.UUID;

public class NeMuelchS2CPacketHandler {
    public static final Identifier WATERING_CAN_PARTICLE_CHANNEL = new Identifier(NeMuelch.MOD_ID, "watering_can_fill");
    public static final Identifier SLEEP_EVENT_S2C_CHANNEL = new Identifier(NeMuelch.MOD_ID, "sleep_event_s2c");
    public static final Identifier CANCEL_SLEEP_EVENT_S2C_CHANNEL = new Identifier(NeMuelch.MOD_ID, "cancel_sleep_event_s2c");


    public static void registerClientReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(WATERING_CAN_PARTICLE_CHANNEL, NeMuelchS2CPacketHandler::handleWateringCanParticlePacket);
        ClientPlayNetworking.registerGlobalReceiver(SLEEP_EVENT_S2C_CHANNEL, NeMuelchS2CPacketHandler::handleSleepEventPacket);
        ClientPlayNetworking.registerGlobalReceiver(CANCEL_SLEEP_EVENT_S2C_CHANNEL, NeMuelchS2CPacketHandler::handleCancelSleepEventPacket);
    }

    private static void handleWateringCanParticlePacket(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler,
                                                        PacketByteBuf buf, PacketSender packetSender) {
        BlockPos target = buf.readBlockPos();

        client.execute(() -> {
            NeMuelch.devLogger("S2C network packet received");
        });
    }

    private static void handleSleepEventPacket(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler,
                                               PacketByteBuf clientBuf, PacketSender packetSender) {
        float delayInSeconds = clientBuf.readFloat();
        UUID playerUuid = clientBuf.readUuid();
        BlockPos sleepingPos = clientBuf.readBlockPos();
        client.execute(() -> {
            NeMuelchClient.clientTickHandler.startTicking(delayInSeconds, () -> {
                PacketByteBuf serverBuf = PacketByteBufs.create();
                serverBuf.writeUuid(playerUuid);
                serverBuf.writeBlockPos(sleepingPos);
                ClientPlayNetworking.send(NeMuelchC2SPacketHandler.SLEEP_EVENT_C2S_CHANNEL, serverBuf);
            });
        });
    }

    private static void handleCancelSleepEventPacket(MinecraftClient client, ClientPlayNetworkHandler clientPlayNetworkHandler,
                                                     PacketByteBuf clientBuf, PacketSender packetSender) {
        client.execute(() -> {
            NeMuelchClient.clientTickHandler.stopAndResetTicking();
        });
    }

}