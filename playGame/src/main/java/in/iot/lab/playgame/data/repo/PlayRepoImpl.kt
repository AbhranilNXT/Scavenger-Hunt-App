package `in`.iot.lab.playgame.data.repo

import `in`.iot.lab.network.data.models.hint.RemoteHint
import `in`.iot.lab.network.data.models.team.RemoteTeam
import `in`.iot.lab.network.state.ResponseState
import `in`.iot.lab.network.utils.NetworkUtil.getResponseState
import `in`.iot.lab.playgame.data.model.UpdatePointRequest
import `in`.iot.lab.playgame.data.remote.PlayApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class PlayRepoImpl @Inject constructor(
    private val apiService: PlayApiService
) : PlayRepo {


    /**
     * This function updates the data when the hint scanned by the user is correct otherwise it
     * shows wrong Hint Scanned.
     */
    override suspend fun updateHints(
        teamId: String,
        updatePointRequest: UpdatePointRequest,
        token: String
    ): ResponseState<RemoteHint> {
        return withContext(Dispatchers.IO) {
            getResponseState {
                apiService.updatePoints(
                    teamId = teamId,
                    updatePointRequest = updatePointRequest,
                    token = token
                )
            }
        }
    }

    /**
     * This function fetches the team data [RemoteTeam] by using the team's Id.
     */
    override suspend fun getTeamById(
        teamId: String,
        token: String
    ): ResponseState<RemoteTeam> {
        return withContext(Dispatchers.IO) {
            getResponseState {
                apiService.getTeamById(
                    teamId = teamId,
                    token = token,
                )
            }
        }
    }
}