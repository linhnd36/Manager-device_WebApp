/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controller.guests;

import com.opensymphony.xwork2.ActionContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import linhnd.daos.BookingDetailDAO;
import linhnd.daos.ResourceDAO;
import linhnd.dtos.ResourceDTO;
import linhnd.dtos.UsersDTO;

/**
 *
 * @author PC
 */
public class SearchAction {

    private static final int PAGE_SIZE = 20;
    private String nameSearch, categorySearch;
    private String dateSearchFrom, dateSearchTo;
    private Date dateFrom, dateTo;
    private List<ResourceDTO> listSearch;
    private String checkList = null;
    private int Page;

    private List<ResourceDTO> subListResource;
    private String pageSearchIndex;
    private int index;

    public SearchAction() {
    }

    public String execute() {
        String url = "success";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Map session = ActionContext.getContext().getSession();
        UsersDTO dtoUser = (UsersDTO) session.get("USER");

        try {
            dateFrom = format.parse(dateSearchFrom);
            dateTo = format.parse(dateSearchTo);
            if (!dateFrom.before(dateTo)) {
                Date tmp = dateFrom;
                dateFrom = dateTo;
                dateTo = tmp;
            }
            dateSearchFrom = format.format(dateFrom);
            dateSearchTo = format.format(dateTo);

            ResourceDAO daoResource = new ResourceDAO();
            BookingDetailDAO daoBookingDetail = new BookingDetailDAO();

            List<ResourceDTO> listSearchNoCheck = daoResource.searchResource(nameSearch, categorySearch, dtoUser.getRoleId());
            listSearch = new ArrayList<>();
            for (ResourceDTO resourceDTO : listSearchNoCheck) {
                int quantityLeft = daoBookingDetail.countResourceInBookingDetail(dateSearchFrom, dateSearchTo, resourceDTO.getResourceId());
                if (resourceDTO.getQuantity() > quantityLeft) {
                    resourceDTO.setQuantityLeft(resourceDTO.getQuantity() - quantityLeft);
                    listSearch.add(resourceDTO);
                }
            }
            if (listSearch.isEmpty()) {
                checkList = "No result !";
            } else {
                int numberOfTour = listSearch.size();
                Page = (int) Math.ceil((double) numberOfTour / PAGE_SIZE);
            }

            index = 1;
            if (pageSearchIndex != null) {
                index = Integer.parseInt(pageSearchIndex);
            }

            int start = (index - 1) * PAGE_SIZE;
            int end = (index) * PAGE_SIZE;
            if (end > listSearch.size()) {
                end = listSearch.size();
            }
            subListResource = listSearch.subList(start, end);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }

    public String getNameSearch() {
        return nameSearch;
    }

    public String getCategorySearch() {
        return categorySearch;
    }

    public String getDateSearchFrom() {
        return dateSearchFrom;
    }

    public String getDateSearchTo() {
        return dateSearchTo;
    }

    public void setNameSearch(String nameSearch) {
        this.nameSearch = nameSearch;
    }

    public void setCategorySearch(String categorySearch) {
        this.categorySearch = categorySearch;
    }

    public void setDateSearchFrom(String dateSearchFrom) {
        this.dateSearchFrom = dateSearchFrom;
    }

    public void setDateSearchTo(String dateSearchTo) {
        this.dateSearchTo = dateSearchTo;
    }

    public List<ResourceDTO> getListSearch() {
        return listSearch;
    }

    public void setListSearch(List<ResourceDTO> listSearch) {
        this.listSearch = listSearch;
    }

    public String getCheckList() {
        return checkList;
    }

    public void setCheckList(String checkList) {
        this.checkList = checkList;
    }

    public int getPage() {
        return Page;
    }

    public void setPage(int Page) {
        this.Page = Page;
    }

    public List<ResourceDTO> getSubListResource() {
        return subListResource;
    }

    public String getPageSearchIndex() {
        return pageSearchIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setSubListResource(List<ResourceDTO> subListResource) {
        this.subListResource = subListResource;
    }

    public void setPageSearchIndex(String pageSearchIndex) {
        this.pageSearchIndex = pageSearchIndex;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    

}
