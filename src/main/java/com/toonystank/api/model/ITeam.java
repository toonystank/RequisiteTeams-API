package com.toonystank.api.model;

import com.toonystank.api.events.TeamXpGainedEvent;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a read-only view of a RequisiteTeam.
 */
@SuppressWarnings("unused")
public interface ITeam {

    /**
     * @return The unique identifier for this team.
     */
    @NotNull UUID getTeamUUID();

    /**
     * @return The display name of this team.
     */
    @NotNull String getName();

    /**
     * @return The UUID of the player who owns this team.
     */
    @NotNull UUID getOwnerUUID();

    /**
     * @return An unmodifiable list of all member UUIDs, including the owner.
     */
    @NotNull List<UUID> getMemberUUIDs();

    /**
     * @return The team's current internal balance.
     */
    double getTeamBalance();

    /**
     * @return An Optional containing the team's home location, or empty if not set.
     */
    @NotNull Optional<Location> getTeamHome();

    /**
     * @return An unmodifiable list of the team's description lines.
     */
    @NotNull List<String> getDescription();

    /**
     * @return An Optional containing the team's banner item, or empty if not set.
     */
    @NotNull Optional<ItemStack> getTeamBanner();

    /**
     * @return The team's level and XP information.
     */
    @NotNull ITeamLevel getTeamLevel();

    /**
     * @return An unmodifiable list of recent team activities.
     */
    @NotNull List<ITeamActivity> getActivityLog();

    /**
     * Checks if a player is a member of this team.
     *
     * @param playerUUID The UUID of the player to check.
     * @return true if the player is a member, false otherwise.
     */
    boolean isMember(@NotNull UUID playerUUID);

    /**
     * Adds XP directly to this team.
     * <p>
     * This will fire a {@link TeamXpGainedEvent}.
     *
     * @param amount The amount of XP to add.
     * @param reason A simple string tag for why XP was added.
     */
    void addXp(double amount, @NotNull String reason);
}