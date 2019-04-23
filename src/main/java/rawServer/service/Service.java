package rawServer.service;

public interface Service {

    /**
     * /v0/status return "ONLINE"
     * GET /v0/entity?id=<> return bytes
     * PUT /vo/entity?id=<> insert new info
     * DELETE v0/entity?id=<> delete temp file
     */
    void start();
    void stop();
}
