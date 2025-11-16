package com.toonystank.api.model.economy;

import com.toonystank.api.enums.EconomyType;
import com.toonystank.api.model.ITeam;
import org.bukkit.entity.Player;

/**
 * Interface defining the "contract" for a team economy strategy.
 * This allows the plugin to seamlessly switch between different economy
 * types (like Vault or Items) by providing a different implementation.
 */
public interface ITeamEconomy {

    /**
     * Gets the team's current balance.
     *
     * @param team The team to check.
     * @return The team's balance.
     */
    double getBalance(ITeam team);

    /**
     * Checks if the team has at least this amount.
     *
     * @param team The team to check.
     * @param amount The amount required.
     * @return true if the team has enough, false otherwise.
     */
    boolean has(ITeam team, double amount);

    /**
     * Forcibly sets a team's balance. (Admin/System use)
     * This method is responsible for updating the balance in the Team object.
     *
     * @param team The team to modify.
     * @param amount The new balance.
     * @return true if successful.
     */
    boolean setBalance(ITeam team, double amount);

    /**
     * Deposits currency from a player to the team.
     * This handles taking the currency from the player (e.g., from their
     * Vault account or inventory) and adding it to the team's balance.
     *
     * @param player The player making the deposit.
     * @param team The team receiving the deposit.
     * @param amount The amount to deposit.
     * @return A {@link EconomyResponse} with the transaction details.
     */
    EconomyResponse deposit(Player player, ITeam team, double amount);

    /**
     * Withdraws currency from a team to a player.
     * This handles removing the currency from the team's balance and
     * giving it to the player (e.g., to their Vault account or inventory).
     *
     * @param player The player receiving the withdrawal.
     * @param team The team to withdraw from.
     * @param amount The amount to withdraw.
     * @return A {@link EconomyResponse} with the transaction details.
     */
    EconomyResponse withdraw(Player player, ITeam team, double amount);

    /**
     * Gets the formatted name for an amount.
     *
     * @param amount The amount to format.
     * @return A formatted string (e.g., "$100.00" or "100 Diamonds").
     */
    String format(double amount);

    /**
     * Gets the type of economy this implementation represents.
     *
     * @return The {@link EconomyType}.
     */
    EconomyType getType();
}