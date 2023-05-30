package fr.nokane.crafting.networking.packet;

import fr.nokane.crafting.client.ClientThirstData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ThirstDataSyncPacket {
    private final int thirst;

    public ThirstDataSyncPacket(int thirst) {
        this.thirst = thirst;
    }

    public ThirstDataSyncPacket(FriendlyByteBuf buf) {
        this.thirst = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(thirst);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            ClientThirstData.set(thirst);
        });
        return true;
    }
}