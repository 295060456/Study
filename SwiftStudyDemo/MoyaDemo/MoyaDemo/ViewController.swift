//
//  ViewController.swift
//  MoyaDemo
//
//  Created by Jobs on 24/10/2021.
//

import UIKit
import Moya
import Alamofire
import RxSwift

class ViewController: UIViewController {
    
    func AF用法一() {
        let parameters: Parameters = ["foo": [1,2,3],
                                      "bar": [],
                                      "baz": "qux"]
        AF.request("https://httpbin.org/post",
                   method: .post,
                   parameters: parameters,
                   encoding: JSONEncoding.default)
    }
    
    func AF用法二(){
        AF.request("https://httpbin.org/get")
          .validate(statusCode: 200..<300)
          .validate(contentType: ["application/json"])
          .responseData { response in
              switch response.result {
                case .success:
                  print("Validation Successful")
                case .failure(let error):
                  print(error)
              }
          }
    }
    
    private let dispose = DisposeBag()
    
    func moya的用法() {
        let provider = MoyaProvider<netTool>()
        
        provider.rx
                .request(.zen, callbackQueue: DispatchQueue.main)
                .asObservable()
                .mapString()
                .subscribe(onNext: { (s) in
                    print(s)
                }, onError: { (e) in
                    print(e)
                })
                .disposed(by: dispose)
        
        provider.rx
                .request(.userProfile("ashfurrow"))
                .asObservable()
                .myMapJSON()
                .mapObject(to: GitHubModel.self)
                .subscribe(onNext: { (model) in
                    print(model.avatar_url ?? "")
                    print(model.company ?? "")
                }, onError: { (e) in
                    print(e)
                })
                .disposed(by: dispose)
    }
    
    override func loadView() {
        super.loadView()
        moya的用法();
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.view.backgroundColor = .red
    }
}

