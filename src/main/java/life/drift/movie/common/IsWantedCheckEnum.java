package life.drift.movie.common;


public enum IsWantedCheckEnum {
    MOVIE_WANTED(1),
    MOVIE_NOT_WANTED(0)
    ;
    private int check;
    IsWantedCheckEnum(int check){
        this.check = check;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
