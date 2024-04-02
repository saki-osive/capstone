<template>
    <div>
        <v-toolbar
            ><h4>
                <pre>
  Tender Number        Tender Name                   Tender Type      Submission Date       Submission Time</pre
                >
            </h4></v-toolbar
        >

        <v-expansion-panels>
            <v-expansion-panel v-for="item in items" :key="item">
                <v-expansion-panel-header
                    ><pre>
  {{ item.tendernumber }}         {{ item.title }}                {{
                            item.type
                        }}            {{ item.sdate }}             {{
                            item.time
                        }}</pre
                    ></v-expansion-panel-header
                >
                <v-expansion-panel-content>
                    <v-container mx-auto>
                        <v-data-table
                            :headers="headers"
                            :items="covers"
                            item-key="name"
                        >
                            <template v-slot:item.assign="{ item }">
                                <v-btn
                                    small
                                    v-model="item.assign"
                                    dark
                                    class="blue darken-2"
                                    :to="{ name: 'ViewAllBids' }"
                                    >Assign an Expert</v-btn
                                >
                            </template>
                        </v-data-table>
                    </v-container>
                </v-expansion-panel-content>
            </v-expansion-panel>
        </v-expansion-panels>
    </div>
</template>

<script>
export default {
    name: 'PendingAssignments',
    data() {
        return {
            items: [
                {
                    title: 'test tender for BSE  ',
                    sdate: '4-12-2011',
                    time: '9:12:00',
                    tendernumber: '8456557532',
                    type: 'Service',
                },
                {
                    title: 'tender supply for d1 ',

                    sdate: '9-12-2001',
                    time: '02:09:01',
                    tendernumber: '8454678532',
                    type: 'Service',
                },
                {
                    title: 'supply  CWEk-31/19-20',
                    sdate: '29-12-2001',
                    time: '09:02:20',
                    tendernumber: '8456535780',
                    type: 'Service',
                },
            ],

            covers: [
                {
                    id: '121',
                    description:
                        'Hello! \n At vero eos et accusamus et iusto odio dignissimos ducimus \n qui blanditiis praesentium  deleniti atque corrupti quos \n doloreset quas molestias excepturi occai cupiditate non provident, \n similique sunt in culpa qui officia animi, id estlaborum et dolorum fuga. \n Et harum quidem rerum facilis est et expedita distinctio. \n Name libero tempore, cum soluta nobis est  cumque nihil impedit quo.',
                    amount: ' 50 Cr.',
                    date: '4-12-2011',
                },
                {
                    id: '122',
                    description:
                        'Hello, deleniti atque corrupti quos dolores et quas molestias excepturi \n sint occaecati cupiditate non in culpa quiofficia deserunt mollitia animi, \n id est fuga. Et harum quidem rerum facilis est et expedita distinctio. \n Nam nobis est eligendi optio cumquenihil impedit quo minus id quod \n maxime placeat. International Ltd.',
                    amount: ' 45 Cr.',
                    date: '9-12-2001',
                },
                {
                    id: '123',
                    description:
                        'Hello! Sed ut perspiciatis unde omnis iste natus error sit voluptatem \n accusantium doloremque laudantium, totam rem aperiam, eaque \n ipsaquae ab illo inventore veritatis et quasi architecto be explicabo. \n Nemo enim ipsam voluptatem quia voluptas sitaspernatur aut odit \n aut fugit, sed quia consequuntur magni  dolores eos ratione voluptatem \n sequi nesciunt. Neque porro quisquam est,qui dolorem ipsum quia dolor \n sit amet, consectetur, adipisci velit, sed quia non numquam eius modi \n tempora incidunt ut labore et doloremagnam aliquam quaerat voluptarem.',
                    amount: ' 60 Cr.',
                    date: '29-12-2001',
                },
            ],
            headers: [
                {
                    text: 'Bid id',
                    value: 'id',
                },
                {
                    text: 'Bid Description',
                    value: 'description',
                },
                {
                    text: 'Closing Dates',
                    value: 'date',
                },
                {
                    text: 'Bid Amount',
                    value: 'amount',
                },
                {
                    text: ' ',
                    value: 'assign',
                },
            ],
        }
    },
}
</script>
