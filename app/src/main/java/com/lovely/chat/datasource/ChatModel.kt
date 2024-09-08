package com.lovely.chat.datasource

data class ChatModel(var name: String, var from: Int, var to: Int, var image: String, var message: String)


 val chatlistData = listOf<ChatModel>(
     ChatModel(
         name = "Alice",
         from = 34,
         to = 101,
         image = "https://images.unsplash.com/photo-1502720705749-3c42f1b4f976",
         message = "Looking forward to it!"
     ),
     ChatModel(
         name = "Bob",
         from = 78,
         to = 101,
         image = "https://images.unsplash.com/photo-1524504388940-b1c1722653e1",
         message = "Let's catch up soon."
     ),
     ChatModel(
         name = "Charlie",
         from = 56,
         to = 101,
         image = "https://images.unsplash.com/photo-1531427186611-ecfd6d936c79",
         message = "Excited about the plan."
     ),
     ChatModel(
         name = "David",
         from = 12,
         to = 101,
         image = "https://images.unsplash.com/photo-1494790108377-be9c29b29330",
         message = "I'll be there on time."
     ),
     ChatModel(
         name = "Eva",
         from = 89,
         to = 101,
         image = "https://images.unsplash.com/photo-1522071820081-009f0129c71c",
         message = "Can't wait to see you."
     ),
     ChatModel(
         name = "Frank",
         from = 23,
         to = 101,
         image = "https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e",
         message = "See you tomorrow then."
     ),
     ChatModel(
         name = "Grace",
         from = 91,
         to = 101,
         image = "https://images.unsplash.com/photo-1506794778202-cad84cf45f1d",
         message = "Meeting at the usual spot."
     ),
     ChatModel(
         name = "Hank",
         from = 65,
         to = 101,
         image = "https://images.unsplash.com/photo-1502767089025-ed3d3bd22d67",
         message = "Looking forward to it!"
     ),
     ChatModel(
         name = "Ivy",
         from = 47,
         to = 101,
         image = "https://images.unsplash.com/photo-1520813792240-56fc4a3765a7",
         message = "Sounds like a great plan."
     ),
     ChatModel(
         name = "Jack",
         from = 19,
         to = 101,
         image = "https://images.unsplash.com/photo-1517841905240-472988babdf9",
         message = "Count me in for sure!"
     )
 )


