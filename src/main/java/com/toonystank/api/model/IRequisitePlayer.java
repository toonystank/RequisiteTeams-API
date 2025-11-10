package com.toonystank.api.model;

import com.toonystank.api.enums.ChatMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents a read-only view of a player's team-related data.
 */
@SuppressWarnings("unused")
public interface IRequisitePlayer {

    /**
     * @return The player's unique identifier.
     */
    @NotNull UUID getUuid();

    /**
     * @return The player's last known in-game name.
     */
    @NotNull String getName();

    /**
     * @return The UUID of the team this player is in, or null if not in a team.
     */
    @Nullable UUID getTeamUUID();

    /**
     * @return The team this player is in, or null if not in a team.
     */
    @Nullable ITeam getTeam();

    /**
     * @return The player's rank within their team, or null if not in a team.
     */
    @Nullable String getRankName(); // Returning a String is safer than the full Rank record in the API

    /**
     * @return The player's current chat mode.
     */
    @NotNull ChatMode getChatMode();
}