package com.mindlesstoys.stick404.astral_aaa.Block;

import com.mindlesstoys.stick404.astral_aaa.Block.Entites.MultiBlockTestEntity;
import com.mindlesstoys.stick404.astral_aaa.Register.AAABlockEntites;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import team.lodestar.lodestone.systems.block.LodestoneEntityBlock;

public class MultiBlockTest extends LodestoneEntityBlock<MultiBlockTestEntity> {
    public MultiBlockTest(Properties properties) {
        super(properties);
    }

    @Override
    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        setBlockEntity(AAABlockEntites.MULTIBLOCK_TEST::get);
        super.onPlace(state, level, pos, oldState, movedByPiston);
    }

    @Override
    public void onBlockBroken(BlockState state, BlockGetter level, BlockPos pos, @Nullable Player player) {
        super.onBlockBroken(state, level, pos, player);
    }
}
