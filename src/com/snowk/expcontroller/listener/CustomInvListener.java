package com.snowk.expcontroller.listener;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class CustomInvListener implements Listener{
	
	public boolean expListenerStats = false;
	
	@EventHandler
	public void onMachineClose(InventoryCloseEvent e) {
		expListenerStats = false;
	}
	
	@EventHandler
	public void onMachineInteract(PlayerInteractEvent e) {
		if (e.hasBlock()) { // interact caused by other plugins will not return block type
			Action isRightClick = e.getAction();
			if (isRightClick.toString().equals("RIGHT_CLICK_BLOCK")) {
				Block b = e.getClickedBlock();
				if (b.getType().toString().equals("IC2_TE")) {
					expListenerStats = true;	
				} else {
					expListenerStats = false;
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerExpChange(PlayerExpChangeEvent e) {
		if (expListenerStats) {
			e.setAmount(0);
		}

	}
}
