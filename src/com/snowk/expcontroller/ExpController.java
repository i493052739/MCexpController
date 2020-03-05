package com.snowk.expcontroller;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import com.snowk.expcontroller.listener.CustomInvListener;
//import com.snowk.expcontroller.metrics.Metrics;
//import java.util.concurrent.Callable;

public class ExpController extends JavaPlugin{
	
	public static ExpController snowkPlugin;
	
	
    @Override
    public void onEnable() {
    	
    	snowkPlugin = this;
    	getLogger().info("Plugin successfully enabled! - By:Bear");
//    	int pluginId = 6684;
//        Metrics metrics = new Metrics(this,pluginId);
//        metrics.addCustomChart(new Metrics.SingleLineChart("players", new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                // (This is useless as there is already a player chart by default.)
//                return Bukkit.getOnlinePlayers().size();
//            }
//        }));
    	registerListeners();
    }
    
    public void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new CustomInvListener(), this);
    }

    @Override
    public void onDisable() {
    	getLogger().info("Plugin successfully disabled!");
    	
    }
    	
}
