package content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawFlame;
import mindustry.world.draw.DrawMulti;

import static mindustry.type.ItemStack.with;

public class IsotBlocks {
    public static Block
            //production
            steamdrill, germaniumrestorer,
            //power

            //crafting
            nilversmelter,
            //distribution
            heavyconveyor, heavyrouter, overflowredirector, heavyjunction, heavybridge, heavysorter,
            //storage
            corecolony,
            //wall
            //ore
            oreznsge, orenicu, acid, silentwater
            ;

    public static void load() {

        //production

        steamdrill = new Drill("steam-drill"){{
            requirements(Category.production, with(Items.copper, 35));
            drillTime = 280;
            size = 2;
            hasPower = true;
            tier = 4;
            updateEffect = Fx.pulverizeMedium;
            drillEffect = Fx.mineBig;

            consumeLiquid(IsotLiquids.steam, 0.08f);
        }};
        germaniumrestorer = new Wall("germanium-restorer"){{
            requirements(Category.defense, with(Items.copper, 2));
            health = 80;
            size = 2;
        }};

        //power

        //crafting

        nilversmelter = new GenericCrafter("nilver-smelter"){{
            requirements(Category.crafting, with(Items.copper, 30));
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(IsotItems.nilver, 1);
            craftTime = 240f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("cca4a4")));
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.07f;

            consumeItems(with(Items.copper, 5, IsotItems.nikel, 2, IsotItems.zink, 2));
            consumePower(0.50f);
        }};

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

        oreznsge = new OreBlock(IsotItems.zink) {{
            oreDefault = false;
        }};
        orenicu = new OreBlock(IsotItems.nikel) {{
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
        silentwater = new Floor("silent-water"){{
            drownTime = 150f;
            status = StatusEffects.wet;
            statusDuration = 240f;
            speedMultiplier = 0.7f;
            variants = 0;
            liquidDrop = Liquids.water;
            liquidMultiplier = 0.5f;
            isLiquid = true;
            cacheLayer = CacheLayer.water;
        }};
    }
}