package com.example.library.UI.BookScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.library.R;

public class BookDetailActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        textView = findViewById(R.id.lbTextContent);
        textView.setText("Chỉ cần một tình yêu đơn giản: yêu là không lừa dối\n" +
                "Cần một người yêu hết tất cả những gì thuộc về tôi thôi\n" +
                "Và em đến - tôi đã tin em là định mệnh đó\n" +
                "Giờ đây rất nhớ... những khi ta bên nhau vui đùa thật ấm áp\n" +
                "Chúng ta không thể xa nhau và giận nhau lâu\n" +
                "Có lẽ sinh ra (là) dành cho nhau\n" +
                "Why it's me\n" +
                "Làm sao đây? Trước mắt tôi là...\n" +
                "Tell me plz.\n" +
                "Khi tất cả những yêu thương sau lưng chỉ là dối trá\n" +
                "I can't suffer unpredictable things you did to me\n" +
                "(Oh oh)\n" +
                "Làm sao tin em đang bước cùng với... oh oh?\n" +
                "Bàn tay ấm em đang siết chặt với... oh oh?\n" +
                "Làm tôi quá bối rối phải quay mặt đi\n" +
                "Vì người đó là\n" +
                "Oh oh\n" +
                "Làm sao vui khi em vẫn cười với tôi\n" +
                "Làm sao tin khi em nói rằng nhớ tôi\n" +
                "Làm sao quên em đã say đắm quyện chặt môi ...\n" +
                "Chỉ cần một lời nói, chỉ cần một tình yêu\n" +
                "Đôi mắt anh đã mỏi vì những giai điệu anh từng phiêu\n" +
                "Tìm về nơi yên ấm, tìm về những dấu chân\n" +
                "Bờ vai em là điểm tựa những khi anh mất thăng bằng\n" +
                "Nhưng đôi chân em bước cùng ai đó nào phải là anh đâu\n" +
                "Em quay lưng khi em đã có một người cạnh em lâu\n" +
                "Câu chuyện coi như chấm dứt\n" +
                "Mang theo bên mình bao nhiêu ấm ức\n" +
                "Giờ là giông tố những ngày mưa\n" +
                "Nhưng mà thôi được anh không cần thêm một ai nữa\n" +
                "Có những lúc chỉ muốn chạy đến bên em ôm em hôn em mà bỏ qua bao dối lừa\n" +
                "Mà làm gì cũng thế thôi tình cũng đã trôi một khi quá giới hạn chỉ còn là những cơn ác mộng\n" +
                "Why it's me\n" +
                "Làm sao đây? Trước mắt tôi là...\n" +
                "Tell me plz.\n" +
                "Khi tất cả những yêu thương sau lưng chỉ là dối trá\n" +
                "I can't suffer unpredictable things you did to me\n" +
                "(Oh oh)\n" +
                "Làm sao tin khi em bước cùng với... oh oh?\n" +
                "Bàn tay ấm em đang siết chặt với... oh oh?\n" +
                "Làm tôi quá bối rối phải quay mặt đi\n" +
                "Vì người đó là\n" +
                "Oh oh\n" +
                "Làm sao vui khi em vẫn cười với tôi\n" +
                "Làm sao tin khi em nói rằng nhớ tôi\n" +
                "Làm sao quên em đã say đắm quyện chặt môi ...\n" +
                "Sài gòn đêm mưa\n" +
                "Muốn nhắn cho em vài dòng\n" +
                "\"Này em ngoan ơi em đã ngủ chưa?\n" +
                "Anh nghĩ khoảng cách quá xa và anh không muốn lại gần thêm nữa...\"\n" +
                "Đôi khi muốn nói... hết trong cuộc gọi... ah ... rằng\n" +
                "\"Anh còn yêu em nhiều biết mấy\n" +
                "Nhưng anh không thể\n" +
                "Nhìn thấy em đang tay trong tay người ấy đi trên đoạn đường về...\"\n" +
                "Nhiều lần cãi vã\n" +
                "Nhiều lần nước mắt\n" +
                "Nhưng mà sau tất cả đều như vụt tắt\n" +
                "Anh như chết lặng khi đứng trước mặt mình\n" +
                "Là yêu thương anh từng gìn giữ sau bao nhiêu cố gắng nào phải là anh đâu\n" +
                "Em quay lưng khi em đã có một người cạnh em lâu\n" +
                "Câu chuyện coi như chấm dứt\n" +
                "Mang theo bên mình bao nhiêu ấm ức\n" +
                "Giờ là giông tố những ngày mưa\n" +
                "Nhưng mà thôi được anh không cần thêm một ai nữa.\n" +
                "(Oh oh)\n" +
                "Làm sao tin em đang bước cùng với... oh oh?\n" +
                "Bàn tay ấm em đang siết chặt với... oh oh?\n" +
                "Làm tôi quá bối rối phải quay mặt đi\n" +
                "Vì người đó là\n" +
                "Oh oh\n" +
                "Làm sao vui khi em vẫn cười với tôi\n" +
                "Làm sao tin khi em nói rằng nhớ tôi\n" +
                "Làm sao quên em đã say đắm quyện chặt môi...\n" +
                "...bạn tôi!\n" +
                "Chỉ cần một lời nói, chỉ cần một tình yêu\n" +
                "Đôi mắt anh đã mỏi vì những giai điệu anh từng phiêu\n" +
                "Tìm về nơi yên ấm, tìm về những dấu chân\n" +
                "Bờ vai em là điểm tựa những khi anh mất thăng bằng\n" +
                "Nhưng đôi chân em bước cùng ai đó nào phải là anh đâu\n" +
                "Em quay lưng khi em đã có một người cạnh em lâu\n" +
                "Câu chuyện coi như chấm dứt\n" +
                "Mang theo bên mình bao nhiêu ấm ức\n" +
                "Giờ là giông tố những ngày mưa\n" +
                "Nhưng mà thôi được anh không cần thêm một ai nữa.");
    }
}