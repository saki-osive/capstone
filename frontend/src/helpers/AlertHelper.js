
import Vue from 'vue'

Vue.mixin({
    methods: {
        showNotification(title,text,type = "success"){
            this.$notify({
                group: 'main',
                title: title,
                text: text,
                type:type,
                position:['bottom', 'right']
            });
        }
    }
})