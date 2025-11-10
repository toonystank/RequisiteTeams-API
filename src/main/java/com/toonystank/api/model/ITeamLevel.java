package com.toonystank.api.model;

/**
 * Represents a read-only view of a team's level and XP.
 */
@SuppressWarnings("unused")
public interface ITeamLevel {

    /**
     * @return The team's current level number.
     */
    int getLevelNumber();

    /**
     * @return The amount of XP the team currently has *towards the next level*.
     */
    double getCurrentXp();

    /**
     * Gets the total XP required to reach the next level.
     * <p>
     * Note: This is the total XP cost for that level (e.g., 1000),
     * not the remaining XP needed (e.g., 1000 - currentXp).
     *
     * @return The XP required for the *next* level, or -1 if at max level.
     */
    double getXpForNextLevel();

    /**
     * Checks if the team has enough XP and meets all requirements to level up.
     *
     * @return true if the team is eligible to level up, false otherwise.
     */
    boolean canLevelUp();
}