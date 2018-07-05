package com.calone.vpgilt.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.verify;

import com.calone.vpgilt.contracts.DetailSaleContract.DetailSaleView;
import com.calone.vpgilt.contracts.VPContract.RepositoryListener;
import com.calone.vpgilt.mock.MockSaleDataSourceFailure;
import com.calone.vpgilt.mock.MockSaleDataSourceSuccess;
import com.calone.vpgilt.models.Sale;
import com.calone.vpgilt.models.SaleDataSource;
import com.calone.vpgilt.models.SaleImage;
import com.calone.vpgilt.models.SaleImageList;
import com.calone.vpgilt.presenters.DetailSalePresenter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by babas on 03/07/18.
 */
public class DetailSalePresenterTests {

    @RunWith(MockitoJUnitRunner.class)
    public static abstract class BaseDetailSaleTest {
        @Mock
        DetailSaleView mDetailView;
        SaleDataSource mMockDataSource;
        String key = "a key";

        @Before
        public void setUp() throws Exception {
            mMockDataSource = getSaleDataSource();
            DetailSalePresenter detailSalePresenter = new DetailSalePresenter(key, mMockDataSource);
            detailSalePresenter.attachView(mDetailView);
        }

        abstract SaleDataSource getSaleDataSource();
    }


    public static class TestLoadDetailSaleSuccess extends BaseDetailSaleTest {

        private String key = "unique_key";
        private String name = "test_sale";
        private String dateB = "2018-06-29T07:28:37Z";
        private String dateE = "2018-06-30T07:28:37Z";
        private String desc = "a good test on sale";

        final Sale mSale;
        final SaleImageList mSaleImageList;

        public TestLoadDetailSaleSuccess() {
            SaleImage saleImage = new SaleImage();
            saleImage.setUrl("https://i2.wp.com/beebom.com/wp-content/uploads/2016/01/Reverse-Image-Search-Engines-Apps-And-Its-Uses-2016.jpg?resize=640%2C426");
            List<SaleImage> list = new LinkedList<>();
            list.add(saleImage);
            mSaleImageList = new SaleImageList();
            mSaleImageList.setLowResolution(list);
            mSale = new Sale();
            mSale.setKey(key);
            mSale.setName(name);
            mSale.setDateBegin(dateB);
            mSale.setDateEnd(dateE);
            mSale.setDescription(desc);
            mSale.setImageUrl(mSaleImageList);
        }

        @Override
        SaleDataSource getSaleDataSource() {
            return new MockSaleDataSourceSuccess(mSale, new ArrayList<Sale>());
        }

        @Test
        public void testLoadDetailSaleSuccess() throws Exception {
            mMockDataSource.loadSale(new RepositoryListener<Sale>() {
                @Override
                public void onSuccess(Sale model) {
                    assertThat("test key", model.getKey(), is(key));
                    assertThat("test name", model.getName(), is(name));
                    assertThat("test key", model.getDescription(), is(desc));
                    assertThat("test key", model.getDateBegin(), is(dateB));
                    assertThat("test key", model.getDateEnd(), is(dateE));
                    assertThat("test list", model.getImageUrl(), is(mSaleImageList));
                }

                @Override
                public void onError(Exception e) {
                    verify(mDetailView).showToast(e.getMessage());
                }
            }, key);
        }
    }

    public static class TestLoadDetailSaleFailed extends BaseDetailSaleTest {

        @Override
        SaleDataSource getSaleDataSource() {
            return new MockSaleDataSourceFailure();
        }

        @Test
        public void testLoadDetailSaleFailed() throws Exception {
            mMockDataSource.loadSale(new RepositoryListener<Sale>() {
                @Override
                public void onSuccess(Sale model) {
                }

                @Override
                public void onError(Exception e) {
                    verify(mDetailView).showToast("Error");
                }
            }, key);
        }
    }
}
