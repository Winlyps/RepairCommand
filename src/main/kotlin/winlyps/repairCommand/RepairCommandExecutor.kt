package winlyps.repairCommand

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class RepairCommandExecutor(private val plugin: RepairCommand) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "Only players can use this command!")
            return true
        }

        val player = sender

        // Check if the player has the required permission or is an operator
        if (!player.hasPermission("repaircommand.use") && !player.isOp) {
            player.sendMessage(ChatColor.RED.toString() + "You do not have permission to use this command!")
            return true
        }

        val itemInHand = player.inventory.itemInMainHand

        // Check if the item in hand is repairable
        if (!isRepairable(itemInHand)) {
            return true
        }

        // Repair the item
        repairItem(itemInHand)

        return true
    }

    private fun isRepairable(item: ItemStack): Boolean {
        return item.type.maxDurability > 0 && item.durability != 0.toShort()
    }

    private fun repairItem(item: ItemStack) {
        item.durability = 0
    }
}