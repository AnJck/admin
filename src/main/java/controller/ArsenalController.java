package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Arsenal;
import service.IArsenalService;

@Controller
@RequestMapping("/sy")
public class ArsenalController {
	
	@Autowired
	private IArsenalService aser;
	
	@RequestMapping("/index.do")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/all.do")
	public String index(Arsenal arsenal,HttpServletRequest request ) throws Exception {
		List<Arsenal> arsenals = aser.findAll();
		request.setAttribute("arsenals", arsenals);
		return "table-data-table";
	}
	//删
	@RequestMapping("/del.do")
	public String del(Arsenal arsenal) throws Exception {
		
		aser.removeById(arsenal);
		return "redirect:/sy/all.do";
	}
	//改前根据ID查
	@RequestMapping("/motify.do")
	public String motify(Arsenal arsenal,HttpServletRequest request) throws Exception {
		Arsenal ar = aser.findById(arsenal);
		request.getSession().setAttribute("ar", ar);
		return "motify";
	}
	//改
	@RequestMapping("/tomt.do")
	public String tomt() throws Exception {
		
		return "tomt";
	}
	//保存到数据库
	@RequestMapping("/todb.do")
	public String todb(Arsenal arsenal) throws Exception {
		aser.motify(arsenal);
		return "redirect:/sy/all.do";
	}
	//增
	@RequestMapping("/add.do")
	public String add() throws Exception {
		
		return "add";
	}
	//添加到数据库
	@RequestMapping("/addtodb.do")
	public String addtodb(Arsenal arsenal) throws Exception {
		aser.save(arsenal);
		return "redirect:/sy/all.do";
	}
}
