package vazkii.patchouli.common.multiblock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.util.ResourceLocation;
import vazkii.patchouli.api.IMultiblock;

public class MultiblockRegistry {

	public static final Map<ResourceLocation, IMultiblock> MULTIBLOCKS = new ConcurrentHashMap<>();

	public static IMultiblock registerMultiblock(ResourceLocation location, IMultiblock multiblock) {
		IMultiblock prev = MULTIBLOCKS.put(location, multiblock);
		if (prev != null) {
			throw new IllegalArgumentException("Multiblock " + location + " already registered");
		} else {
			return multiblock.setId(location);
		}
	}

}
