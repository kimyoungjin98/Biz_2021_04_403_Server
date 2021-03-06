package com.callor.book.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.book.model.BookDTO;
import com.callor.book.model.BookVO;
import com.callor.book.persistance.DBContract;
import com.callor.book.persistance.DBinfo;
import com.callor.book.service.BookService;

public class BookServiceImplV1 implements BookService{

	protected Connection dbConn;
	
	public BookServiceImplV1() {
		
		dbConn = DBContract.getDBConnection();
		
	}
	
	protected List<BookDTO> select(PreparedStatement pStr) throws SQLException{
		
		List<BookDTO> bookList = new ArrayList<BookDTO>();
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()){
		
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBk_isbn(rSet.getString(DBinfo.BOOK.bk_isbn));
			bookDTO.setBk_title(rSet.getString(DBinfo.BOOK.bk_title));
			bookDTO.setBk_cceo(rSet.getString(DBinfo.BOOK.bk_cceo));
			bookDTO.setBk_cname(rSet.getString(DBinfo.BOOK.bk_cname));
			bookDTO.setBk_auname(rSet.getString(DBinfo.BOOK.bk_auname));
			bookDTO.setBk_autel(rSet.getString(DBinfo.BOOK.bk_autel));
			bookDTO.setBk_date(rSet.getString(DBinfo.BOOK.bk_date));
			bookDTO.setBk_price(rSet.getInt(DBinfo.BOOK.bk_price));
			bookDTO.setBk_pages(rSet.getInt(DBinfo.BOOK.bk_pages));
			bookList.add(bookDTO);
		}
		rSet.close();
		
		
		return bookList;
	}
	
	@Override
	public List<BookDTO> selectAll() {
		String sql = " SELECT * FROM view_도서정보 ";
		
		PreparedStatement pStr = null;
		
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<BookDTO> bookList = this.select(pStr);
			pStr.close();
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BookDTO findById(String bk_isbn) {
		
		String sql = " SELECT * FROM view_도서정보 ";
		sql += " WHERE ISBN = ? ";
		
		PreparedStatement pStr = null;
		try {
			
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bk_isbn.trim());
			
			List<BookDTO> bookList = this.select(pStr);
			if(bookList != null && bookList.size() > 0) {
				pStr.close();
				return bookList.get(0);
			} 
			pStr.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<BookDTO> findByTitle(String bk_title) {
		String sql = " SELECT * FROM view_도서정보 ";
		sql += " WHERE ";
		sql += DBinfo.BOOK.bk_title;
		sql += " LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		try {
			
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, bk_title.trim());
			List<BookDTO> bookList = this.select(pStr);
			pStr.close();
			return bookList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<BookDTO> findByCName(String bk_cname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDTO> findByAName(String bk_aname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BookVO bookVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookVO bookVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String bk_isbn) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
