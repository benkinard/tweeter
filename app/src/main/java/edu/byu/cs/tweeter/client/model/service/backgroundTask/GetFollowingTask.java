package edu.byu.cs.tweeter.client.model.service.backgroundTask;

import android.os.Handler;

import java.io.IOException;
import java.util.List;

import edu.byu.cs.tweeter.model.domain.AuthToken;
import edu.byu.cs.tweeter.model.domain.User;
import edu.byu.cs.tweeter.model.net.TweeterRemoteException;
import edu.byu.cs.tweeter.model.net.request.PagedRequest;
import edu.byu.cs.tweeter.model.net.response.FollowingResponse;
import edu.byu.cs.tweeter.util.Pair;

/**
 * Background task that retrieves a page of other users being followed by a specified user.
 */
public class GetFollowingTask extends PagedTask<User> {
    private static final String LOG_TAG = "GetFollowingTask";

    public GetFollowingTask(AuthToken authToken, User targetUser, int limit, User lastFollowee,
                            Handler messageHandler) {
        super(messageHandler, authToken, targetUser, limit, lastFollowee);
    }

    @Override
    protected Pair<List<User>, Boolean> getItems(AuthToken authToken, User targetUser, int limit, User lastFollowee) throws IOException, TweeterRemoteException {
        PagedRequest<User> followingRequest = new PagedRequest<>(authToken, targetUser.getAlias(), limit, lastFollowee);
        FollowingResponse followingResponse = getServerFacade().getFollowees(followingRequest, "/getfollowing");

        setResponse(followingResponse);

        return new Pair<>(followingResponse.getItems(), followingResponse.getHasMorePages());
    }
}
