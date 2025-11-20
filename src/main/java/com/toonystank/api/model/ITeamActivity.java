package com.toonystank.api.model;

import com.toonystank.api.enums.ActivityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Represents a single logged activity within a team.
 */
@SuppressWarnings("unused")
public interface ITeamActivity {

    /**
     * @return The unique ID of this activity record.
     */
    @NotNull UUID getActivityId();

    /**
     * @return The type of activity (e.g. MEMBER_JOIN, BALANCE_DEPOSIT).
     */
    @NotNull ActivityType getType();

    /**
     * @return The timestamp (in milliseconds) when this activity occurred.
     */
    long getTimestamp();

    /**
     * @return The UUID of the player or entity that performed the action.
     */
    @NotNull UUID getActorUUID();

    /**
     * @return The UUID of the target (player or team), if applicable.
     */
    @Nullable UUID getTargetUUID();

    /**
     * @return Additional metadata (e.g. deposit amount, new rank name), if applicable.
     */
    @Nullable String getMetaData();
}