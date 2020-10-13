package com.example.library.Common.ConmonInterface;

/**
 * Interface for Activity
 */
public interface IActivity {

    /**
     * Khởi tạo UI cho Activity mapping với các element
     * set up elements in UI mapping to local elements
     */
    void setupUI();

    /**
     * Tạo ra những event khi thao tác với element
     * set up action for element in UI
     */
    void setupAction();


}
