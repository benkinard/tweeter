package edu.byu.cs.tweeter.model.net.response;

import java.util.List;
import java.util.Objects;

import edu.byu.cs.tweeter.model.domain.User;

public class FollowerResponse extends PagedResponse {
    private List<User> followers;

    public FollowerResponse(String message) {
        super(false, message, false);
    }

    public FollowerResponse(List<User> followers, boolean hasMorePages) {
        super(true, hasMorePages);
        this.followers = followers;
    }

    public List<User> getFollowers() {
        return followers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(followers);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        FollowerResponse that = (FollowerResponse) obj;

        return (Objects.equals(followers, that.followers) &&
                Objects.equals(this.getMessage(), that.getMessage()) &&
                this.isSuccess() == that.isSuccess());
    }
}
