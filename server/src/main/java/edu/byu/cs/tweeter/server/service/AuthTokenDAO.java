package edu.byu.cs.tweeter.server.service;

import edu.byu.cs.tweeter.model.domain.AuthToken;
import edu.byu.cs.tweeter.server.dao.DataAccessException;

public interface AuthTokenDAO {
    public void createAuthToken(AuthToken authToken, String alias) throws DataAccessException;
    public AuthToken getAuthToken(String token);
    public String getUserAlias(String token) throws DataAccessException;
    public void deleteAuthToken(AuthToken authToken) throws DataAccessException;
}