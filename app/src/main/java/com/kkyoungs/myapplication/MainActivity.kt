package com.kkyoungs.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kkyoungs.myapplication.Observer.ObserverViewModel
import com.kkyoungs.myapplication.Singleton.SingletonEx
import com.kkyoungs.myapplication.bridge.Best
import com.kkyoungs.myapplication.bridge.Kkommi
import com.kkyoungs.myapplication.bridge.Lotto
import com.kkyoungs.myapplication.bridge.Puppy
import com.kkyoungs.myapplication.bridge.Treasure
import com.kkyoungs.myapplication.databinding.ActivityMainBinding
import com.kkyoungs.myapplication.factorymethod.EKRamanStore
import com.kkyoungs.myapplication.iterator.Baby
import com.kkyoungs.myapplication.iterator.Baby_Group
import com.kkyoungs.myapplication.prototype.User
import com.kkyoungs.myapplication.proxy.Proxy_Image
import org.junit.jupiter.api.Assertions.*

/**
 * 1.factoryMethodPattern
 * 2.prototypePattern
 * 3.SingleTonPattern
 * 4.Bridge Pattern
 * 5.proxy pattern
 * 6.iterator
 * 7.Observer
 */
class MainActivity : AppCompatActivity(), Observer<String> {
    var ekStore = EKRamanStore()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    /**
     * 오류내용 : Cannot access '<init>': it is package-private in 'User'
     * User 초기화 요류가 났지만 User class에서 오버라이딩 한부분을 제거하고 아래와같이 초기화 하였더니 오류 해결 ~!
     */
    
    private var user = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        BulDackRaman()
        SinRaman()
        protoTypePattern()
        testSingleTon()
        bridgeTest()
        proxy()
        iterator()
        observer()
    }

    // factoryMethodPattern
    private fun BulDackRaman() {
        ekStore.orderRaman("BulDak")
    }

    private fun SinRaman() {
        ekStore.orderRaman("Sin")
    }

    // prototypePattern
    private fun protoTypePattern(){
        user.name = "로또"
        user.job = "왕쟈"
        user.age = 4

        println("--------------------------prototype Pattern------------------------------")
        println("첫번째 user1" + ", 이름 : "+user.name + ", 직업 : "+user.job + ", 나이 : "+user.age)

        val user2 = user.clone() as User
        println("두번째 user2" + ", 이름 : "+user2.name + ", 직업 : "+user2.job + ", 나이 : "+user2.age)

        user2.name = "꼬미"
        user2.job = "굥쥬"
        user2.age = 1
        println("세번째 user2" + ", 이름 : "+user2.name + ", 직업 : "+user2.job + ", 나이 : "+user2.age)
        println("네번째 user1" + ", 이름 : "+user.name + ", 직업 : "+user.job + ", 나이 : "+user.age)

    }

    // SingleTonPattern
    private fun testSingleTon(){
        println("----------------------------singleton Pattern -------------------------------------")
        val singleton1 = SingletonEx.getInstance(this)
        val singleton2 = SingletonEx.getInstance(this)
        singleton1.printName("로또")
        singleton2.printName("꼬미")
        SingletonEx.getInstance(this).printName("메롱")
    }

    /**
     * Junit assert
     * - assertEquals와 assertNotEquals는 인스턴스의 동등성 비교를 위해 사용
     * - assertEquals의 앞에는 나오기 기대되는 값이오고, 뒤에는 실제 테스트에서 나온값
     * 계속 AssertionFailedError 오류가 났는데 아래와같이 정확히 쓰니까 오류가 나지 않았다 !!
     * 이렇게 테스트 코드 작성 완료 및 브리지 패턴 완료
     *
     *
     * 브리지 패턴은 추상화(abstraction)와 구현 (implement)이 독립적으로 다른 계층 구조를 가질 수 있고, 클라이언트 어플리케이션으로 부터 구현을 숨기고 싶을때 사용.
     *
     * Bridge Pattern
     */
    private fun bridgeTest(){
        val lotto :Puppy = Lotto()
        val kkommi :Puppy = Kkommi()

        val best = Best(lotto)
        assertEquals("최고 lotto", best.cute())

        val treasure = Treasure(kkommi)
        assertEquals("보물 kkommi", treasure.cute())

        println("----------------------------bridge Pattern -------------------------------------")

        println(best.cute())
        println(treasure.cute())

    }

    /**
     * 메인에서 Real_image에 직접 접근 하지 않고, Proxy_image 객체를 생성해서 대신 시킨다.
     * Proxy 는 displayImage() 메서드를 호출하고, 그 반환 값을 메인에 반환
     *
     * proxy pattern
     */
    private fun proxy(){
        println("----------------------------proxy Pattern -------------------------------------")
        val image1 = Proxy_Image("baby.png")
        val image2 = Proxy_Image("baby_fighting.png")
        image1.displayImage()
        println()
        image2.displayImage()

    }
    /**
     * iterator pattern
     */

    private fun iterator(){
        val babyGroup = Baby_Group(2)
        babyGroup.addBaby(Baby("로또", 4))
        babyGroup.addBaby(Baby("꼬미", 1))

        val iterator= babyGroup.iterator()

        while (iterator.hasNext()){
            val baby : Baby = iterator.next()

            println("----------------------------iterator Pattern -------------------------------------")
            println("이름 : " + baby.name)
            println("나이 : " + baby.age)
        }
    }

    /**
     * Observer Pattern
     * 버튼이 눌릴때마다 라이브 데이터를 바꾸는 로직.
     * 버튼이 눌릴때마다 ViewModel에 LiveData를 만들고, 그 데이터에 옵저버를 달아서 값이 바뀔 때 마다 onChange 메소드 호출
     */
    private fun observer(){
        // 프로바이더를 통해 뷰모델 가져오기
        val viewModel : ObserverViewModel = ViewModelProvider(this)[ObserverViewModel::class.java]
        // 뷰모델에 있는 LiveData의 값의 변경사항을 관찰 할 수 있는 옵저버 설정한다.
        viewModel.liveData.observe(this, this)

        var i = 0
        binding.observerButton.setOnClickListener {
            viewModel.liveData.postValue("$i")
            i++
        }
    }

    //LiveData 가 바뀌면 호출.
    override fun onChanged(value: String) {
        println("----------------------------observer Pattern -------------------------------------")
        println(">>>>>>>>>> test $value")
    }

}