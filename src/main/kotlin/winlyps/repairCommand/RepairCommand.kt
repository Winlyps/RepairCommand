package winlyps.repairCommand

import org.bukkit.plugin.java.JavaPlugin

class RepairCommand : JavaPlugin() {

    override fun onEnable() {
        // Register the command
        getCommand("repair")?.setExecutor(RepairCommandExecutor(this))

        // Register the event listener

        logger.info("RepairCommand plugin has been enabled!")
    }

    override fun onDisable() {
        logger.info("RepairCommand plugin has been disabled!")
    }
}