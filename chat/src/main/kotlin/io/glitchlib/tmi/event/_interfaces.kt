package io.glitchlib.tmi.event

import io.glitchlib.model.Badge
import io.glitchlib.model.IEvent
import io.glitchlib.model.UserType
import io.glitchlib.tmi.ChatRoom
import io.glitchlib.tmi.ChatRoomUser
import io.glitchlib.tmi.UserDM
import java.awt.Color

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IChannel {
    val channelName: String
}

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IUser {
    val username: String
}

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IChannelUser : IChannel, IUser

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IDChannelUser : IDChannel, IDUser

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IDUser : IEvent {
    val userId: Long
}

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IDChannel : IEvent {
    val channelId: Long
}

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface GlobalUserState {
    val badges: Set<Badge>
    val color: Color
    val userType: UserType
    val displayName: String

    val hasPrime: Boolean
        get() = badges.any { it.id == "premium" }
    val hasTurbo: Boolean
        get() = badges.any { it.id == "turbo" }
    val isTwitchAdmin: Boolean
        get() = badges.any { it.id == "admin" }
    val isTwitchStaff: Boolean
        get() = badges.any { it.id == "staff" }
}

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface ChannelUserState : GlobalUserState {
    val isMod: Boolean
        get() = badges.any { it.id == "moderator" }
    val isSubscriber: Boolean
        get() = badges.any { it.id == "subscriber" }
    val isVip: Boolean
        get() = badges.any { it.id == "vip" }
    val isBroadcaster: Boolean
        get() = badges.any { it.id == "broadcaster" }
}

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IMessage : IDUser, IUser {
    val message: String?
}

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IChatRoom : IChannel {
    val room: ChatRoom
}

/**
 *
 * @author Damian Staszewski [damian@stachuofficial.tv]
 * @version %I%, %G%
 * @since 1.0
 */
interface IChatRoomUser : IChatRoom {
    val user: ChatRoomUser
    val userDirect: UserDM
}