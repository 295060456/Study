//
//  ViewController.swift
//  TableViewDemo
//
//  Created by Jobs on 24/10/2021.
//

import UIKit
import SnapKit

class ViewController: UIViewController,
                      UITableViewDataSource,
                      UITableViewDelegate {
    
//    var dataArray:[String] = NSMutableArray(array: ["first","second","three","four","five","six","seven","eight"]) as! [String]
//    var imageArray:[String] = NSMutableArray(array: ["1.jpeg","1.jpeg","1.jpeg","1.jpeg","1.jpeg","1.jpeg","1.jpeg","1.jpeg"]) as! [String]
    
    var dataArray : NSMutableArray = ["first","second","three","four","five","six","seven","eight"]
    var imageArray : NSMutableArray = ["1.jpeg","1.jpeg","1.jpeg","1.jpeg","1.jpeg","1.jpeg","1.jpeg","1.jpeg"]
    
    var isEdit = false//判断tableview是否是在编辑状态
    let cellID = "testCellID"
    
    lazy var tableView: UITableView = {
//        let tableView = UITableView(frame: CGRect(x:0,
//                                                  y:0,
//                                                  width:self.view.frame.size.width,
//                                                  height:self.view.frame.size.height),
//                                    style: UITableView.Style.plain)
        
        let tableView = UITableView()
        
        tableView.dataSource = self
        tableView.delegate = self
        tableView.rowHeight  = 50
        
        tableView.register(UITableViewCell.classForCoder(), forCellReuseIdentifier: cellID)
        self.view.addSubview(tableView)
        
        tableView.snp.makeConstraints { make in
            make.edges.equalTo(self.view)
        }
        
        tableView.tableFooterView = UIView()
        return tableView
    }()
    
    /// Lifecycle
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "UITableView"
        self.navigationItem.rightBarButtonItem = UIBarButtonItem(title: "编辑",
                                                                 style: UIBarButtonItem.Style.done,
                                                                 target: self,
                                                                 action: #selector(ViewController.rightBarButtonItemClicked))

        tableView.alpha = 1
    }
    
    @objc func rightBarButtonItemClicked() {
        if isEdit {
            self.tableView.setEditing(false, animated: true)
            isEdit = false
        } else {
            self.tableView.setEditing(true, animated: true)
            isEdit = true
        }
    }
    //返回cell的行数
    func tableView(_ tableView: UITableView,
                   numberOfRowsInSection section: Int) -> Int {
        return self.dataArray.count
    }
    //返回cell
    func tableView(_ tableView: UITableView,
                   cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: cellID, for: indexPath)
        
        cell.textLabel?.text = self.dataArray[indexPath.row] as? String
        cell.imageView?.image = UIImage(named: self.imageArray[indexPath.row] as! String)
        return cell;
    }
    //可被编辑
    func tableView(_ tableView: UITableView,
                   canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    //确定编辑模式（默认是滑动删除模式）
    func tableView(_ tableView: UITableView,
                   editingStyleForRowAt indexPath: IndexPath) -> UITableViewCell.EditingStyle {
        return UITableViewCell.EditingStyle.delete
    }
    //具体编辑操作（默认删除操作）
    func tableView(_ tableView: UITableView,
                   commit editingStyle: UITableViewCell.EditingStyle,
                   forRowAt indexPath: IndexPath) {
        //
        self.dataArray.removeObject(at: indexPath.row)
        //
        self.tableView.deleteRows(at: [indexPath], with: UITableView.RowAnimation.top)
    }
    //允许移动某一行
    func tableView(_ tableView: UITableView,
                   canMoveRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    //实现排序
    func tableView(_ tableView: UITableView,
                   moveRowAt sourceIndexPath: IndexPath,
                   to destinationIndexPath: IndexPath) {
        //后面加as。。。
        let object:AnyObject = self.dataArray[sourceIndexPath.row] as AnyObject
        //
        self.dataArray.removeObject(at: sourceIndexPath.row)
        self.dataArray.insert(object, at: destinationIndexPath.row)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
}
/*
 
 1、defer 所声明的 block 会在当前代码执行退出后被调用
 2、正因为它提供了一种延时调用的方式，所以一般会被用来做资源释放或者销毁
 
 **/

/*
 inout关键字的作用即引用传递，可以在函数内改变函数外的值
 **/
