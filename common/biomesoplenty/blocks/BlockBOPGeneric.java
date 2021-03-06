package biomesoplenty.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import biomesoplenty.BiomesOPlenty;
import biomesoplenty.api.Items;

public class BlockBOPGeneric extends Block
{
	public enum BlockType
	{
		ASH_STONE, HARD_SAND, HARD_DIRT, HARD_ICE, DRIED_DIRT, CRAG_ROCK, MUD_BRICK, HOLY_DIRT, CRYSTAL;
	}

	private Icon texture;
	private BlockType type;

	public BlockBOPGeneric(int id, Material material, BlockType type)
	{
		super(id, material);
		this.type = type;
		this.setCreativeTab(BiomesOPlenty.tabBiomesOPlenty);

		switch (type)
		{
		case ASH_STONE:
			setHardness(1.0F).setStepSound(Block.soundStoneFootstep);
			break;

		case CRAG_ROCK:
			setHardness(1.0F).setStepSound(Block.soundGravelFootstep);
			break;

		case DRIED_DIRT:
			setHardness(0.1F).setStepSound(Block.soundStoneFootstep);
			break;

		case HARD_DIRT:
			setHardness(0.9F).setStepSound(Block.soundStoneFootstep);
			break;

		case HARD_ICE:
			setHardness(0.75F).setStepSound(Block.soundStoneFootstep);
			break;

		case HARD_SAND:
			setHardness(0.7F).setStepSound(Block.soundSandFootstep);
			break;

		case MUD_BRICK:
			setHardness(1.0F).setResistance(2.0F).setStepSound(Block.soundStoneFootstep);
			break;

		case HOLY_DIRT:
			setHardness(0.6F).setStepSound(Block.soundGravelFootstep);
			break;

		case CRYSTAL:
			setHardness(0.15F).setResistance(5.0F).setLightValue(1.0F).setStepSound(Block.soundGlassFootstep);
			break;

		default:
			break;
		}
	}
	
	@Override
	public String getUnlocalizedName() 
	{
		return "tile.bop.generic" + "." + type.toString().toLowerCase();
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		switch (type)
		{
		case ASH_STONE:
			texture = iconRegister.registerIcon("biomesoplenty:ashstone");
			break;

		case CRAG_ROCK:
			texture = iconRegister.registerIcon("biomesoplenty:cragrock");
			break;

		case DRIED_DIRT:
			texture = iconRegister.registerIcon("biomesoplenty:drieddirt");
			break;

		case HARD_DIRT:
			texture = iconRegister.registerIcon("biomesoplenty:harddirt");
			break;

		case HARD_ICE:
			texture = iconRegister.registerIcon("biomesoplenty:hardice");
			break;

		case HARD_SAND:
			texture = iconRegister.registerIcon("biomesoplenty:hardsand");
			break;

		case MUD_BRICK:
			texture = iconRegister.registerIcon("biomesoplenty:mudbrick");
			break;

		case HOLY_DIRT:
			texture = iconRegister.registerIcon("biomesoplenty:holydirt");
			break;

		case CRYSTAL:
			texture = iconRegister.registerIcon("biomesoplenty:crystal");
			break;

		default:
			break;
		}
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		switch (type)
		{
		case CRYSTAL:
			return Items.miscItems.get().itemID;

		default:
			return blockID;
		}
	}

	@Override
	public int damageDropped(int meta)
	{
		switch (type)
		{
		case CRYSTAL:
			return 4;

		default:
			return meta;
		}
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		switch (type)
		{
		case CRYSTAL:
			return 4;

		default:
			return 1;
		}
	}

	@Override
	public Icon getIcon(int side, int meta)
	{
		return texture;
	}
}
