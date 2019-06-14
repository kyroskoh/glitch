package io.glitchlib.v5.internal.model.json

import io.glitchlib.GlitchClient
import io.glitchlib.model.UserType
import io.glitchlib.v5.model.json.AuthUser
import io.glitchlib.v5.model.json.User
import java.util.Date

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
data class UserImpl(
    override val client: GlitchClient,
    override val userBio: String,
    override val displayName: String,
    override val logo: String,
    override val username: String,
    override val userType: UserType,
    override val id: Long,
    override val createdAt: Date,
    override val updatedAt: Date
) : User

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
data class AuthUserImpl(
    override val client: GlitchClient,
    override val userBio: String,
    override val displayName: String,
    override val logo: String,
    override val username: String,
    override val userType: UserType,
    override val id: Long,
    override val createdAt: Date,
    override val updatedAt: Date,
    override val email: String,
    override val isEmailVerified: Boolean,
    override val isPushNotifications: Boolean,
    override val isEmailNotifications: Boolean,
    override val isPartnered: Boolean,
    override val isTwitterConnected: Boolean
) : AuthUser