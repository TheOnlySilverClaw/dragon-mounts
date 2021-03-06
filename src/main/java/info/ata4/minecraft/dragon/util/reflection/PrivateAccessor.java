/*
 ** 2016 April 23
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package info.ata4.minecraft.dragon.util.reflection;

import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

/**
 * Interface used to touch Minecraft's private members ( ͡° ͜ʖ ͡°).
 * 
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public interface PrivateAccessor {
    
    static final String[] GUIMAINMENU_SPLASHTEXT = new String[] {"splashText", "field_73975_c"};
    
    default Map<Integer, DataWatcher.WatchableObject> dataWatcherGetWatchedObjects(DataWatcher dataWatcher) {
        return ReflectionHelper.getPrivateValue(DataWatcher.class, dataWatcher,
                new String[] {"watchedObjects", "field_75695_b"});
    }
    
    default List<EntityAITasks.EntityAITaskEntry> tasksGetExecutingTaskEntries(EntityAITasks tasks) {
        return ReflectionHelper.getPrivateValue(EntityAITasks.class, tasks,
                new String[] {"executingTaskEntries", "field_75780_b"});
    }
    
    default boolean entityIsJumping(EntityLivingBase entity) {
        return ReflectionHelper.getPrivateValue(EntityLivingBase.class, entity,
                new String[] {"isJumping", "field_70703_bu"});
    }
    
    default String mainMenuGetSplashText(GuiMainMenu menu) {
        return ReflectionHelper.getPrivateValue(GuiMainMenu.class, menu,
                GUIMAINMENU_SPLASHTEXT);
    }
    
    default void mainMenuSetSplashText(GuiMainMenu menu, String splash) {
        ReflectionHelper.setPrivateValue(GuiMainMenu.class, menu, splash,
                GUIMAINMENU_SPLASHTEXT);
    }
}
