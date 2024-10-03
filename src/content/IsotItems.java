package content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class IsotItems {
    public static Item
            zink,nikel,germanium,pulsealloy,nilver,sulfur,seaweed,rubidium,aluminium,azide,lithium;

    public static final Seq<Item> snewerusItems = new Seq<>();

    public static void load(){
        zink = new Item("zink",Color.valueOf("8697a5")){{
            cost = 0.5f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        nikel = new Item("nikel",Color.valueOf("dee6e9")){{
            cost = 1f;
            hardness = 2;
            alwaysUnlocked = true;
        }};
        germanium = new Item("germanium",Color.valueOf("dee6e9")){{
            cost = 1.5f;
            alwaysUnlocked = true;
        }};
        sulfur = new Item("sulfur",Color.valueOf("e3c367")){{
            hardness = 0;
            alwaysUnlocked = true;
            flammability = 0.2f;
        }};
        pulsealloy = new Item("pulsealloy",Color.valueOf("b3485d")){{
            cost = 2f;
            charge = 1.2f;
            hardness = 1;
            alwaysUnlocked = true;
        }};
        nilver = new Item("nilver",Color.valueOf("8697a5")){{
            cost = 2f;
            alwaysUnlocked = true;
        }};
        seaweed = new Item("seaweed",Color.valueOf("8697a5")){{
            alwaysUnlocked = true;
            flammability = 0.2f;
        }};
        rubidium = new Item("rubidium",Color.valueOf("8697a5")){{
            cost = 3f;
            alwaysUnlocked = true;
        }};
        aluminium = new Item("aluminium",Color.valueOf("8697a5")){{
            cost = 1f;
            hardness = 2;
            alwaysUnlocked = true;
        }};
        azide = new Item("azide",Color.valueOf("8697a5")){{
            alwaysUnlocked = true;
            flammability = 0.8f;
        }};
        lithium = new Item("lithium",Color.valueOf("8697a5")){{
            cost = 2.5f;
            hardness = 1;
            alwaysUnlocked = true;
            flammability = 0.1f;
        }};

        snewerusItems.addAll (
                copper,zink,nikel,germanium,graphite,sulfur,fissileMatter,pulsealloy,seaweed,rubidium,aluminium,azide,lithium
        );
    }
}
