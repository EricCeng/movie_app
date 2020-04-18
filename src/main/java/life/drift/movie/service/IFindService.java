package life.drift.movie.service;

import life.drift.movie.utils.ServerResponse;

public interface IFindService {

    ServerResponse findSelectedReview();

    ServerResponse findSelectedPost();

}
