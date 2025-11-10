package com.toonystank.api.enums;

import java.util.List;
import java.util.stream.Stream;

/**
 * Represents all possible permissions a team rank can have.
 */
@SuppressWarnings("unused")
public enum RankPermissions {

    DELETE_TEAM,
    CHANGE_TEAM_NAME,
    SET_RANK,
    WITHDRAW_MONEY,

    HOME_SET,
    ADD_MEMBER,
    REMOVE_MEMBER,
    PROMOTE_MEMBER,
    DEMOTE_MEMBER,
    CHANGE_DESCRIPTION,
    SET_BANNER,
    INVITE_MEMBER,

    USE_TEAM_CHAT,
    CONTRIBUTE_XP,
    HOME_USE,
    DEPOSIT_MONEY;

    /**
     * Gets an immutable list of all permissions.
     *
     * @return A list of all RankPermissions.
     */
    public static List<RankPermissions> getAllPermissions() {
        // This is safer than List.of() in an enum constructor
        return List.of(RankPermissions.values());
    }

    /**
     * Gets a list of all permission names as strings.
     *
     * @return A list of all permission names.
     */
    public static List<String> getAllPermissionsString() {
        return Stream.of(RankPermissions.values())
                .map(RankPermissions::name)
                .toList();
    }

    /**
     * Gets a RankPermission from a string.
     *
     * @param permission The string to parse.
     * @return The matching RankPermission, or null if not found.
     */
    public static RankPermissions getFromString(String permission) {
        if (permission == null) {
            return null;
        }
        try {
            return RankPermissions.valueOf(permission.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // Not found
        }
    }
}