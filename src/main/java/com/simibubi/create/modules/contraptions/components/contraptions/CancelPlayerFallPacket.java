package com.simibubi.create.modules.contraptions.components.contraptions;

import java.util.function.Supplier;

import com.simibubi.create.foundation.packet.SimplePacketBase;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class CancelPlayerFallPacket extends SimplePacketBase {

	public CancelPlayerFallPacket() {
	}

	public CancelPlayerFallPacket(PacketBuffer buffer) {
	}

	@Override
	public void write(PacketBuffer buffer) {
	}

	@Override
	public void handle(Supplier<Context> context) {
		context.get().enqueueWork(() -> {
			ServerPlayerEntity sender = context.get().getSender();
			sender.fall(sender.fallDistance, 1.0F);
			sender.fallDistance = 0;
			sender.onGround = true;
		});
		context.get().setPacketHandled(true);
	}

}
