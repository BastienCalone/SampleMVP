package com.calone.vpgilt.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.calone.vpgilt.contracts.SalesContract.SalesView;
import com.calone.vpgilt.contracts.VPContract.RepositoryListener;
import com.calone.vpgilt.mock.MockSaleDataSourceFailure;
import com.calone.vpgilt.mock.MockSaleDataSourceSuccess;
import com.calone.vpgilt.models.Sale;
import com.calone.vpgilt.models.SaleDataSource;
import com.calone.vpgilt.models.SaleImage;
import com.calone.vpgilt.models.SaleImageList;
import com.calone.vpgilt.presenters.SalesPresenter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.verify;

/**
 * Created by babas on 04/07/18.
 */

public class SalesPresenterTest {

    @RunWith(MockitoJUnitRunner.class)
    public static abstract class BaseSalesTest {
        @Mock
        SalesView mSalesView;
        SaleDataSource mMockDataSource;

        @Before
        public void setUp() throws Exception {
            mMockDataSource = getSalesDataSource();
            SalesPresenter salesPresenter = new SalesPresenter(mMockDataSource);
            salesPresenter.attachView(mSalesView);
        }

        abstract SaleDataSource getSalesDataSource();
    }

    public static class TestLoadSalesSuccess extends BaseSalesTest {

        final Sale mSale;
        final List<Sale> mListSale = new ArrayList<>();

        public TestLoadSalesSuccess() {
            SaleImage saleImage = new SaleImage();
            saleImage.setUrl("https://image.jpg");
            List<SaleImage> list = new LinkedList<>();
            list.add(saleImage);
            SaleImageList saleImageList = new SaleImageList();
            saleImageList.setLowResolution(list);
            mSale = new Sale();
            mSale.setKey("unique_key");
            mSale.setName("test_sale");
            mSale.setDateBegin("2018-06-29T07:28:37Z");
            mSale.setDateEnd("2018-06-30T07:28:37Z");
            mSale.setDescription("a good test on sale");
            mSale.setImageUrl(saleImageList);
            mListSale.add(mSale);
        }

        @Override
        SaleDataSource getSalesDataSource() {
            return new MockSaleDataSourceSuccess(mSale, mListSale);
        }

        @Test
        public void testLoadSalesSuccess() throws Exception {
            getSalesDataSource().loadSales(new RepositoryListener<List<Sale>>() {
                @Override
                public void onSuccess(List<Sale> model) {
                    assertThat("test list", model.get(0), is(mSale));
                }

                @Override
                public void onError(Exception e) {
                }
            });
        }
    }

    public static class TestLoadSalesFailure extends BaseSalesTest {

        @Override
        SaleDataSource getSalesDataSource() {
            return new MockSaleDataSourceFailure();
        }

        @Test
        public void testLoadSaleFailed() throws Exception {
            verify(mSalesView).showToast("Error");
        }
    }
}

