package com.toonystank.api.model.economy;

/**
 * A simple data-carrier record to report the outcome
 * of an economy transaction (deposit or withdraw).
 * This is returned by methods in ITeamEconomy.
 */
public record EconomyResponse(
        /**
         * @return true if the transaction was successful.
         */
        boolean success,

        /**
         * @return The team's new balance after the transaction.
         */
        double newBalance,

        /**
         * @return A message describing the outcome (e.g., "Success!" or "Insufficient funds.").
         * This is not pre-formatted and is intended for logging or custom formatting.
         */
        String message
) {}