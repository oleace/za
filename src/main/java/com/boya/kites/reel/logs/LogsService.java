package com.boya.kites.reel.logs;

import org.canedata.exception.DataAccessException;

import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14/12/11.
 */
public interface LogsService {

    /**
     * 增加一个系统日志
     *
     * @param logs
     * @throws DataAccessException
     */

    public void log(Logs logs) throws DataAccessException;

    /**
     * 查询日志
     *
     * @param uid
     * @param module
     * @param type
     * @param start
     * @param end
     * @param level
     * @return
     * @throws DataAccessException
     */
    public List<Logs> gets(String uid, String module, int type, long start, long end, int level) throws DataAccessException;

    /**
     * 获取登录过系统的用户
     *
     * @return
     * @throws DataAccessException
     */
    public List<String> getUsers() throws DataAccessException;

    /**
     * 获取业务系统模块
     *
     * @return
     * @throws DataAccessException
     */
    public List<String> getModules() throws DataAccessException;
}
