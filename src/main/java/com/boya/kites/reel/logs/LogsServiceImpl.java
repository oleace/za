package com.boya.kites.reel.logs;

import com.boya.commons.Constant;
import com.github.moor.paging.Pager;
import com.github.moor.paging.Pagination;
import org.canedata.core.logging.LoggerFactory;
import org.canedata.core.util.StringUtils;
import org.canedata.entity.Entity;
import org.canedata.entity.EntityFactory;
import org.canedata.exception.DataAccessException;
import org.canedata.expression.shield.ExpressionA;
import org.canedata.field.Fields;
import org.canedata.logging.Logger;
import org.canedata.provider.mongodb.entity.Options;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  IN BOYA by BaiLiJun on 14/12/11.
 */
public class LogsServiceImpl implements LogsService {

    private static final Logger LOG = LoggerFactory.getLogger(LogsServiceImpl.class);

    private EntityFactory entityFactory;

    public EntityFactory getEntityFactory() {
        return entityFactory;
    }

    public void setEntityFactory(EntityFactory entityFactory) {
        this.entityFactory = entityFactory;
    }

    @Override
    public void log(Logs logs) throws DataAccessException {

        Entity entity = null;

        try {
            entity = entityFactory.get(Logs.Meta.TABLENAME);

            entity.put(Logs.Meta.BID, logs.getBid())
                    .put(Logs.Meta.CONTENTSTRING, logs.getCs())
                    .put(Logs.Meta.CRTAT, logs.getCrtAt())
                    .put(Logs.Meta.LEVEL, logs.getLevel())
                    .put(Logs.Meta.MODULE, logs.getModule())
                    .put(Logs.Meta.QUERYSTRING, logs.getQs())
                    .put(Logs.Meta.REFER, logs.getRefer())
                    .put(Logs.Meta.SYSTEMID, logs.getSid())
                    .put(Logs.Meta.TID, logs.getTid())
                    .put(Logs.Meta.TYPE, logs.getType())
                    .put(Logs.Meta.UID, logs.getUid())
                    .put(Logs.Meta.URL, logs.getUrl())
                    .create();

        } catch (Exception ex) {
            LOG.error(Constant.EXCEPTIONHINT, "log", this.getClass().getName(), ex);
        } finally {
            if (null != entity && !entity.hasClosed()) {
                entity.close();
            }
        }

    }

    @Override
    public List<Logs> gets(String uid, String module, int type, long start, long end, int level) throws DataAccessException {

        Entity entity = null;

        List<Logs> rlt = null;

        try {

            entity = entityFactory.get(Logs.Meta.TABLENAME);

            ExpressionA expra = entity.expr().isNotEmpty("_id");

            if (StringUtils.isNotBlank(uid)) {
                expra.and().equals(Logs.Meta.UID, uid);
            }

            if (StringUtils.isNotBlank(module)) {
                expra.and().equals(Logs.Meta.MODULE, module);
            }

            if (Logs.Meta.IGNORE != type) {
                expra.and().equals(Logs.Meta.TYPE, type);
            }

            if (Logs.Meta.IGNORE != start) {
                expra.and().greaterThan(Logs.Meta.CRTAT, start);
            }

            if (Logs.Meta.IGNORE != end) {
                expra.and().lessThan(Logs.Meta.CRTAT, end);
            }

            if (Logs.Meta.IGNORE != level) {
                expra.and().equals(Logs.Meta.LEVEL, level);
            }

            Pagination pagination = Pager.page();

            int startPage = (pagination.getCurrentPage() - 1) * pagination.getPageSize();

            int count = entity.filter(expra).opt(Options.RETAIN, true).count().intValue();

            pagination.setItemCount(count);


            List<Fields> fieldses = entity.filter(expra).orderDESC(Logs.Meta.CRTAT).list(startPage, pagination.getPageSize());
            if (null != fieldses) {

                rlt = new ArrayList<>();

                for (Fields fields : fieldses) {
                    Logs logs = new Logs();
                    logs = logs.fill(fields);
                    rlt.add(logs);
                }
            }


        } catch (Exception ex) {
            LOG.error(Constant.EXCEPTIONHINT, "gets", this.getClass().getName(), ex);
            throw new DataAccessException(ex);
        } finally {
            if (null != entity && !entity.hasClosed()) {
                entity.close();
            }
        }
        return rlt;
    }

    @Override
    public List<String> getUsers() throws DataAccessException {
        Entity entity = null;
        List<String> rlt = null;

        try {

            entity = entityFactory.get(Logs.Meta.TABLENAME);
            List<Fields> fieldses = entity.distinct(Logs.Meta.UID);

            if (null != fieldses) {
                rlt = new ArrayList<String>();
                for (Fields fields : fieldses) {
                    rlt.add(fields.getString(Logs.Meta.UID));
                }

            }

        } catch (Exception ex) {
            LOG.error(Constant.EXCEPTIONHINT, "getUsers", this.getClass().getName(), ex);
            throw new DataAccessException(ex);
        } finally {
            if (null != entity && !entity.hasClosed()) {
                entity.close();
            }
        }
        return rlt;
    }

    @Override
    public List<String> getModules() throws DataAccessException {
        Entity entity = null;
        List<String> rlt = null;

        try {

            entity = entityFactory.get(Logs.Meta.TABLENAME);
            List<Fields> fieldses = entity.distinct(Logs.Meta.MODULE);

            if (null != fieldses) {
                rlt = new ArrayList<String>();
                for (Fields fields : fieldses) {
                    rlt.add(fields.getString(Logs.Meta.MODULE));
                }

            }

        } catch (Exception ex) {
            LOG.error(Constant.EXCEPTIONHINT, "getModules", this.getClass().getName(), ex);
            throw new DataAccessException(ex);
        } finally {
            if (null != entity && !entity.hasClosed()) {
                entity.close();
            }
        }
        return rlt;
    }
}
