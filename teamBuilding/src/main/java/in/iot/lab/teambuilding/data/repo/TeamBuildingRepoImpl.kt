package `in`.iot.lab.teambuilding.data.repo

import `in`.iot.lab.network.data.models.team.RemoteTeam
import `in`.iot.lab.network.data.models.user.RemoteUser
import `in`.iot.lab.network.state.ResponseState
import `in`.iot.lab.network.utils.NetworkUtil.getRetrofitResponseState
import `in`.iot.lab.teambuilding.data.remote.TeamBuildingApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * Team Building Features Repo which is responsible for fetching data for the View Model.
 *
 * @param apiService Retrofit Instance enabling the repo layer to make api calls.
 */
class TeamBuildingRepoImpl @Inject constructor(
    private val apiService: TeamBuildingApiService
) : TeamBuildingRepo {


    override suspend fun getUserById(userId: String): ResponseState<RemoteUser> {
        return withContext(Dispatchers.IO) {
            getRetrofitResponseState {
                apiService.getUserById(userId = userId)
            }
        }
    }

    override suspend fun getTeamById(teamId: String): ResponseState<RemoteTeam> {
        return withContext(Dispatchers.IO) {
            getRetrofitResponseState {
                apiService.getTeamById(teamId = teamId)
            }
        }
    }
}