package com.aigestudio.wheelpicker;

import android.graphics.Typeface;

import java.util.List;

/**

 *
 * @author AigeStudio 2015-12-03
 * @author AigeStudio 2015-12-08
 * @author AigeStudio 2015-12-12
 * @author AigeStudio 2016-06-17
 *         New project structure
 * @version 1.1.0
 */
public interface IWheelPicker {






    /**
     * Get the count of current visible items in WheelPicker
     *
     * @return
     */
    int getVisibleItemCount();

    /**

     * Set the count of current visible items in WheelPicker
     * The count of current visible items in WheelPicker must greater than 1
     * Notice:count of current visible items in WheelPicker will always is an odd number, even you
     * can set an even number for it, it will be change to an odd number eventually
     * By default, the count of current visible items in WheelPicker is 7
     *
     * @param count
     */
    void setVisibleItemCount(int count);

    /**
     *
     * <p>
     * Whether WheelPicker is cyclic or not
     *
     * @return
     */
    boolean isCyclic();

    /**

     * Set whether WheelPicker is cyclic or not
     * WheelPicker's items will be end to end and in an infinite loop if setCyclic true, and there
     * is no border whit scroll when WheelPicker in cyclic state
     *
     * @param isCyclic
     */
    void setCyclic(boolean isCyclic);

    /**
     *
     *
     */
    void setOnItemSelectedListener(WheelPicker.OnItemSelectedListener listener);


    int getSelectedItemPosition();


    void setSelectedItemPosition(int position);

    /**
     * Get the position of current selected item in data source
     * The difference between {@link #getSelectedItemPosition()}, the value this method return will
     * change by WheelPicker scrolled
     *
     * @return
     */
    int getCurrentItemPosition();

    /**
     * Get data source of WheelPicker
     *
     * @return
     */
    List getData();

    /**

     * {@link #setSelectedItemPosition(int)}
     * <p>
     * Set data source of WheelPicker
     * The data source can be any type, WheelPicker will change the data to string when it draw the
     * item.
     * There is a default data source when you not set the data source for WheelPicker.
     * Set data source for WheelPicker will reset state of it, you can refer to
     * {@link #setSelectedItemPosition(int)} for more details.
     *
     * @param data
     */
    void setData(List data);

    /**
       {@link #setMaximumWidthTextPosition(int)}
     * <p>
     * Set items of WheelPicker if has same width
     * WheelPicker will traverse the data source to calculate each data text width to find out the
     * maximum text width for the final view width, this process maybe spends a lot of time and
     * reduce efficiency when data source has large amount data, in most large amount data case,
     * data text always has same width, you can call this method tell to WheelPicker your data
     * source has same width to save time and improve efficiency.
     * Sometimes the data source you set is positively has different text width, but maybe you know
     * the maximum width text's position in data source, then you can call
     * {@link #setMaximumWidthTextPosition(int)} tell to WheelPicker where is the maximum width text
     * in data source, WheelPicker will calculate its width base on this text which found by
     * position. If you don't know the position of maximum width text in data source, but you have
     * maximum width text, you can call {@link #setMaximumWidthText(String)} tell to WheelPicker
     * what maximum width text is directly, WheelPicker will calculate its width base on this text.
     *
     * @param hasSameSize
     */
    void setSameWidth(boolean hasSameSize);

    /**
     *
     *
     * Whether items has same width or not
     *
     * @return
     */
    boolean hasSameWidth();

    /**
     *
     *
     * @param listener
     * @see com.aigestudio.wheelpicker.WheelPicker.OnWheelChangeListener
     */
    void setOnWheelChangeListener(WheelPicker.OnWheelChangeListener listener);

    /**
     *
     * <p>
     * Get maximum width text
     *
     * @return
     */
    String getMaximumWidthText();

    /**
     *
     * <p>
     * Set maximum width text
     *
     * @param text
     * @see #setSameWidth(boolean)
     */
    void setMaximumWidthText(String text);

    /**
     *
     * <p>
     * Get the position of maximum width text in data source
     *
     * @return
     */
    int getMaximumWidthTextPosition();

    /**
     *
     * <p>
     * Set the position of maximum width text in data source
     *
     * @param position
     * @see #setSameWidth(boolean)
     */
    void setMaximumWidthTextPosition(int position);

    /**
     *
     * Get text color of current selected item
     * For example 0xFF123456
     *
     * @return
     */
    int getSelectedItemTextColor();

    /**
     *
     * <p>
     * Set text color of current selected item
     * For example 0xFF123456
     *
     */
    void setSelectedItemTextColor(int color);

    /**
     *
     * <p>
     * Get text color of items
     * For example 0xFF123456
     *
     * @return
     */
    int getItemTextColor();

    /**
     *
     * <p>
     * Set text color of items
     * For example 0xFF123456
     *
     */
    void setItemTextColor(int color);

    /**
     * <p>
     * Get text size of items
     * Unit in px
     *
     */
    int getItemTextSize();

    /**
     * <p>
     * Set text size of items
     * Unit in px
     *
     */
    void setItemTextSize(int size);

    /**
     * <p>
     * Get space between items
     * Unit in px
     *
     */
    int getItemSpace();

    /**
     * <p>
     * Set space between items
     * Unit in px
     *
     */
    void setItemSpace(int space);

    /**

     * Set whether WheelPicker display indicator or not
     * WheelPicker will draw two lines above an below current selected item if display indicator
     * Notice:Indicator's size will not participate in WheelPicker's size calculation, it will drawn
     * above the content
     *
     * @param hasIndicator
     */
    void setIndicator(boolean hasIndicator);

    /**
     * <p>
     * Whether WheelPicker display indicator or not
     *
     */
    boolean hasIndicator();

    /**
     * <p>
     * Get size of indicator
     * Unit in px
     *
     * @return
     */
    int getIndicatorSize();

    /**
     *
     * <p>
     * Set size of indicator
     * Unit in px
     *
     */
    void setIndicatorSize(int size);

    /**
     * Get color of indicator
     * For example 0xFF123456
     *
     */
    int getIndicatorColor();

    /**
     * Set color of indicator
     * For example 0xFF123456
     *
     */
    void setIndicatorColor(int color);

    /**
     * Set whether WheelPicker display curtain or not
     * WheelPicker will draw a rectangle as big as current selected item and fill specify color
     * above content if curtain display
     *
     */
    void setCurtain(boolean hasCurtain);

    /**
     * Whether WheelPicker display curtain or not
     *
     */
    boolean hasCurtain();

    /**
     * Get color of curtain
     * For example 0xFF123456
     *
     */
    int getCurtainColor();

    /**
     * Set color of curtain
     * For example 0xFF123456
     *
     */
    void setCurtainColor(int color);

    /**
     * Set whether WheelPicker has atmospheric or not
     * WheelPicker's items will be transparent from center to ends if atmospheric display
     *
     * @param hasAtmospheric 滚轮选择器是否有空气感
     */
    void setAtmospheric(boolean hasAtmospheric);

    /**
     * Whether WheelPicker has atmospheric or not
     *
     */
    boolean hasAtmospheric();

    /**
     * <p>
     * Whether WheelPicker enable curved effect or not
     *
     */
    boolean isCurved();

    /**
     * Set whether WheelPicker enable curved effect or not
     * If setCurved true, WheelPicker will display with curved effect looks like ends bend into
     * screen with perspective.
     * WheelPicker's curved effect base on strict geometric model, some parameters relate with size
     * maybe invalidated, for example each item size looks like different because of perspective in
     * curved, the space between items looks like have a little difference
     *
     */
    void setCurved(boolean isCurved);

    /**
     * Get alignment of WheelPicker
     *
     */
    int getItemAlign();

    /**
     * Set alignment of WheelPicker
     * The default alignment of WheelPicker is {@link WheelPicker#ALIGN_CENTER}
     *
     *              {@link WheelPicker#ALIGN_CENTER}
     *              {@link WheelPicker#ALIGN_LEFT}
     *              {@link WheelPicker#ALIGN_RIGHT}
     */
    void setItemAlign(int align);

    /**
     * Get typeface of item text
     *
     */
    Typeface getTypeface();

    /**
     * <p>
     * Set typeface of item text
     * Set typeface of item text maybe cause WheelPicker size change
     *
     */
    void setTypeface(Typeface tf);
}