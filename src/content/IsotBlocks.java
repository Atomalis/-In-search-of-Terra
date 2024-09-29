package content;

import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.graphics.CacheLayer;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.storage.CoreBlock;

import static mindustry.type.ItemStack.with;

public class IsotBlocks {
    public static Block
            //production
            steamdrill,
            //power

            //crafting
            nilversmelter,
            //distribution
            heavyconveyor, heavyrouter, overflowredirector, heavyjunction, heavybridge, heavysorter,
            //storage
            corecolony,
            //wall
            //ore
            orezink, orenikel, acid
            ;

    public static void load() {
        //crafting

        //distribution

        heavyconveyor = new Conveyor("heavy-conveyor"){{
            requirements(Category.distribution, with(Items.copper, 2, IsotItems.zink, 1));
            health = 10;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            junctionReplacement = heavyjunction;
            bridgeReplacement = heavybridge;
        }};
        heavyrouter = new Router("heavy-router"){{
            requirements(Category.distribution, with(Items.copper, 5, IsotItems.zink, 2));
            buildCostMultiplier = 4f;
            health = 12;
        }};
        overflowredirector = new OverflowGate("overflow-redirector"){{
            requirements(Category.distribution, with(Items.copper, 6, IsotItems.zink, 3));
            buildCostMultiplier = 3f;
            health = 12;
        }};
        heavysorter = new Sorter("heavy-sorter"){{
            requirements(Category.distribution, with(Items.copper, 8, IsotItems.zink, 2));
            buildCostMultiplier = 3f;
            health = 12;
        }};
        heavybridge = new BufferedItemBridge("heavy-bridge"){{
            requirements(Category.distribution, with(Items.copper, 5, IsotItems.zink, 5));
            fadeIn = moveArrows = false;
            range = 4;
            speed = 74f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
            health = 12;
        }};
        heavyjunction = new Junction("heavy-junction"){{
            requirements(Category.distribution, with(Items.copper, 3, IsotItems.zink, 2));
            speed = 26;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
            health = 12;
        }};

        //storage

        corecolony = new CoreBlock("core-colony"){{
            requirements(Category.effect, with( Items.copper, 200, IsotItems.germanium, 100, IsotItems.nikel, 400));
            size = 3;
            alwaysUnlocked = true;
            isFirstTier = true;
            unitType = IsotUnitTypes.colonist;
            health = 200;
            itemCapacity = 800;
            unitCapModifier = 8;
        }};

        //ore

        orezink = new OreBlock(IsotItems.zink) {{
            oreDefault = false;
        }};
        orenikel = new OreBlock(IsotItems.nikel) {{
            oreDefault = false;
        }};
        acid = new Floor("acidfloor"){{
            drownTime = 150f;
            status = StatusEffects.corroded;
            statusDuration = 240f;
            speedMultiplier = 0.5f;
            variants = 0;
            liquidDrop = IsotLiquids.acid;
            liquidMultiplier = 0.5f;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
        }};
    }
}