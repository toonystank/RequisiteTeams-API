package com.toonystank.api;

import com.toonystank.api.enums.RankPermissions;
import com.toonystank.api.events.TeamXpGainedEvent; // We will create this event soon
import com.toonystank.api.model.IRequisitePlayer; // We will create this interface soon
import com.toonystank.api.model.ITeam; // We will create this interface soon
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;

/**
 * The main entry point for the RequisiteTeams API.
 * <p>
 * Access this service via Bukkit's ServicesManager:
 * <pre>
 * {@code
 * RegisteredServiceProvider<IRequisiteTeamsAPI> provider = Bukkit.getServicesManager().getRegistration(IRequisiteTeamsAPI.class);
 * if (provider != null) {
 * IRequisiteTeamsAPI api = provider.getProvider();
 * // You can now use the api...
 * }
 * }
 * </pre>
 */
@SuppressWarnings("unused")
public interface IRequisiteTeamsAPI {

    /**
     * Gets the {@link ITeam} object for a team.
     *
     * @param teamUUID The UUID of the team.
     * @return An Optional containing the ITeam, or empty if not found.
     */
    Optional<ITeam> getTeam(@NotNull UUID teamUUID);

    /**
     * Gets the {@link ITeam} object by name.
     *
     * @param teamName The name of the team (case-sensitive).
     * @return An Optional containing the ITeam, or empty if not found.
     */
    Optional<ITeam> getTeam(@NotNull String teamName);

    /**
     * Gets the team a player belongs to.
     *
     * @param playerUUID The UUID of the player.
     * @return An Optional containing the {@link ITeam}, or empty if the player is not in a team.
     */
    Optional<ITeam> getTeamByPlayer(@NotNull UUID playerUUID);

    /**
     * Gets the {@link IRequisitePlayer} object for a player.
     * <p>
     * This provides access to team-specific player data like their Rank.
     *
     * @param playerUUID The UUID of the player.
     * @return An Optional containing the IRequisitePlayer, or empty if not loaded.
     */
    Optional<IRequisitePlayer> getPlayer(@NotNull UUID playerUUID);

    /**
     * Checks if a player has a specific team permission.
     *
     * @param playerUUID The UUID of the player.
     * @param permission The {@link RankPermissions} to check.
     * @return true if the player has the permission, false otherwise (or if not in a team).
     */
    boolean playerHasPermission(@NotNull UUID playerUUID, @NotNull RankPermissions permission);

    /**
     * Adds XP to the team that the specified player is in.
     * <p>
     * This method is the recommended way for external plugins to grant team XP.
     * It will automatically find the player's team and fire a {@link TeamXpGainedEvent}.
     *
     * @param playerUUID The UUID of the player.
     * @param xpAmount   The amount of XP to add.
     * @param reason     A simple string tag for why XP was added (e.g., "CyberLevel_Quest")
     * @return true if XP was successfully added, false if the player is not in a team.
     */
    boolean addXpToPlayerTeam(@NotNull UUID playerUUID, double xpAmount, @NotNull String reason);
}