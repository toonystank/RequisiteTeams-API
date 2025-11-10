package com.toonystank.api.events;

import com.toonystank.api.model.ITeam;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a team gains XP, either from an API call or internal plugin action.
 * This event is cancellable.
 */
@SuppressWarnings("unused")
public class TeamXpGainedEvent extends Event implements Cancellable {
    
    private static final HandlerList handlers = new HandlerList();
    private final ITeam team;
    private double amount;
    private final String reason;
    private boolean isCancelled;

    public TeamXpGainedEvent(@NotNull ITeam team, double amount, @NotNull String reason) {
        this.team = team;
        this.amount = amount;
        this.reason = reason;
        this.isCancelled = false;
    }

    /**
     * @return The team that is gaining the XP.
     */
    @NotNull
    public ITeam getTeam() {
        return team;
    }

    /**
     * @return The amount of XP being gained.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Set the amount of XP to be gained.
     * @param amount The new amount.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the reason for the XP gain (e.g., "CyberLevel_Quest").
     * @return The reason.
     */
    @NotNull
    public String getReason() {
        return reason;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}