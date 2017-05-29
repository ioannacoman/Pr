package ro.sci.dao;

import ro.sci.meniu.AbstractModel;

import java.util.Collection;

/**
 * Created by Skipy on 5/12/2017.
 */

public interface BaseDAO<T extends AbstractModel> {	Collection<T> getAll(); }
