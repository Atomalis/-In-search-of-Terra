package example;

import arc.Events;
import arc.util.Log;
import arc.util.Time;
import content.*;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class ExampleJavaMod extends Mod{

    public ExampleJavaMod(){
        Log.info("Loaded ExampleJavaMod constructor.");
        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("In Search Of Terra");
                dialog.cont.add("Current version:").row();
                dialog.cont.button("0.0.1 g", dialog::hide).size(200f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        IsotItems.load();
        IsotLiquids.load();
        IsotUnitTypes.load();
        //IsotUiAC.load();
        IsotBlocks.load();
        IsotPlanets.load();
    }
}