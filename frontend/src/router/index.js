import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/Login.vue'
import BidderManagerIndex from '@/stakeholderScreens/bidderManager/BidderManagerIndex.vue'
import OnBoardingIndex from '@/stakeholderScreens/onBoarding/OnBoardingIndex.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/login',
        props: true,
    },
    {
        path: '/login',
        name: 'Login',
        props: true,
        component: Login,
    },
    {
        path: '/register',
        name: 'Register',
        props: true,
        component: () => import('@/views/Register.vue'),
    },
    {
        path: '/dashboard',
        name: 'Dashboard',
        component: () => import('@/dashboard/Dashboard.vue'),
        props: true,
    },
    {
        path: '/bidderManager',
        name: 'BidderManagerIndex',
        props: true,
        component: BidderManagerIndex,
        children: [
            {
                path: 'dashboard',
                name: 'BidderManagerDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidderManager/BidderManagerDashboard.vue'
                    ),
            },
            {
                path: 'addBidder',
                name: 'AddBidder',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidderManager/src/addBidder/AddBidder.vue'
                    ),
            },
            {
                path: 'bidderadded',
                name: 'BidderAdded',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidderManager/src/addBidder/BidderAdded.vue'
                    ),
            },
            {
                path: 'viewAll',
                name: 'ViewAll',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidderManager/src/ViewAll.vue'
                    ),
            },
            {
                path: 'bidderDetails',
                name: 'BidderDetails',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidderManager/src/pendingForReview/BidderDetail.vue'
                    ),
            },
            {
                path: 'pendingForReview',
                name: 'PendingForReview',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidderManager/src/pendingForReview/PendingForReview.vue'
                    ),
            },
            {
                path: 'bidderRegistered',
                name: 'BidderRegisteredConfirmation',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidderManager/src/pendingForReview/BidderRegistered.vue'
                    ),
            },
            {
                path: 'suspendedBidder',
                name: 'SuspendedBidder',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidderManager/src/SuspendedBidders.vue'
                    ),
            },
        ],
    },
    //CVO
    {
        path: '/cvo',
        name: 'CVOIndex',
        component: () =>
            import('@/stakeholderScreens/chiefVigilanceOfficer/CVOIndex.vue'),
        children: [
            {
                path: 'dashboard',
                name: 'CVODashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/chiefVigilanceOfficer/CVODashboard.vue'
                    ),
            },
            {
                path: 'cvoProfile',
                name: 'CVOProfile',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/chiefVigilanceOfficer/src/CVOProfile.vue'
                    ),
            },
        ],
    },
    // Tender Creator
    {
        path: '/tenderCreator',
        name: 'TenderCreatorIndex',
        component: () =>
            import('@/stakeholderScreens/tenderCreator/TenderCreatorIndex.vue'),
        children: [
            {
                path: 'createTender',
                name: 'CreateTender',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderCreator/src/TenderCreateMain.vue'
                    ),
            },

            {
                path: 'TCDashboard',
                name: 'TCDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderCreator/TCDashboard.vue'
                    ),
            },


            {
                path: 'activeTenders',
                name: 'TenderCreatorActiveTenders',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderCreator/src/TenderCreatorActiveTenders.vue'
                    ),
            },
            {
                path: 'pastTenders',
                name: 'PastTenders',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderCreator/src/PastTenders.vue'
                    ),
            },
            {
                path: 'drafts',
                name: 'DraftTendersList',
                props: true,
                component: () => import('@/stakeholderScreens/tenderCreator/src/DraftTendersList.vue'),
            },
            // {
            //     path: 'tenderTemplates',
            //     name: 'TenderTemplates',
            //     component: () => import('@/stakeholderScreens/tenderCreator/src/TenderTemplates.vue'),
            // },
            {
                path: 'listOfTendersSentForApproval',
                name: 'ListOfTendersSentForApproval',
                props: true,
                component: () => import('@/stakeholderScreens/tenderCreator/src/submittedTenderstatus/ListOfTendersSentForApproval.vue'),
            },
            {
                path: 'statusOfSubmitted',
                name: 'StatusOfSubmitted',
                props: true,
                component: () => import('@/stakeholderScreens/tenderCreator/src/submittedTenderstatus/StatusOfSubmitted.vue'),
            },
            {
                path: 'tenderSentForCorrigendum',
                name: 'TenderSentForCorrigendum',
                props: true,
                component: () => import('@/stakeholderScreens/tenderCreator/src/TenderSentForCorrigendum.vue'),
            },
            
        ],
    },

    // Tender manager
    {
        path: '/tenderManager',
        name: 'TenderManagerIndex',
        props: true,
        component: () =>
            import('@/stakeholderScreens/tenderManager/TenderManagerIndex.vue'),
        children: [
            {
                path: 'dashboard',
                name: 'TenderDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/TendersDashboard.vue'
                    ),
            },
            {
                path: 'activeTenders',
                name: 'ActiveTenders',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/ActiveTenders.vue'
                    ),
            },
            {
                path: 'review/pending',
                name: 'PendingReview',

                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/pendingReview/PendingReviewMain.vue'
                    ),
            },
            {

                path: 'review/tenderDetails',
                name: 'TenderDetails',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/pendingReview/TenderDetails.vue'
                    ),
            },
            {
                name: 'RejectedTenderDetails',
                path: 'RejectedTenderDetails',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/RejectedTenderDetails.vue'
                    ),
            },

            {
                path: 'markedCorregendum',
                name: 'MarkedCorregendum',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/pendingReview/Corregendum.vue'
                    ),
            },
            {
                path: 'review/success',
                name: 'AcceptTender',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/pendingReview/AcceptTender.vue'
                    ),
            },
            {
                name: 'RejectTender',
                path: 'rejectTender',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/pendingReview/RejectTender.vue'
                    ),
            },
            {
                path: 'rejectedTenders',
                name: 'RejectedTenders',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/RejectedTenders.vue'
                    ),
            },

            {
                path: 'upcomingTenders',
                name: 'UpcomingTenders',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/upcoming/UpcomingTenders.vue'
                    ),
            },
            {
                path: 'inviteBidder',
                name: 'InviteBidder',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/upcoming/InviteBidder.vue'
                    ),
            },
            {
                path: 'viewSubmissions',
                name: 'ViewSubmissions',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/ViewSubmissions.vue'
                    ),
            },
            {
                path: 'trackStatus',
                name: 'TrackStatus',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/tenderManager/src/TrackStatus.vue'
                    ),
            },
        ],
    },
    // register screen part of onboarding screen
    {
        path: '/register',
        name: 'Register',
        props: true,
        component: () => import('../views/Register.vue'),
    },
    // onBoarding
    {
        path: '/onboarding',
        name: 'OnBoardingIndex',
        props: true,
        component: OnBoardingIndex,
        children: [
            {
                path: 'review/pending',
                name: 'UserPendingReview',
                props: true,
                component: () => import('@/stakeholderScreens/onBoarding/user/BidderPendingReview.vue'),
            },
            {
                path: 'review/details',
                name: 'ReviewUser',
                props: true,
                component: () => import('@/stakeholderScreens/onBoarding/user/ReviewUser.vue'),
            },

            {
                path: 'addUser',
                name: 'AddUser',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/onBoarding/user/AddUser.vue'),
            },
            {
                path: 'viewAll',
                name: 'ViewAll',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/onBoarding/user/ViewAll.vue'),
            },
            {
                path: 'allUserRoles',
                name: 'AllUserRoles',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/onBoarding/user/AllUserRoles.vue'
                    ),
            },


            {
                path: 'OnboardingDashboard',
                name: 'OnboardingDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/onBoarding/OnboardingDashboard.vue'
                    ),
            },
        ],
    },
    // Auditor
    {
       path: '/auditorIndex',
       name: 'AuditorIndex',
       component: () => import('@/stakeholderScreens/auditor/AuditorIndex.vue'),
       children: [
           {
            path: 'auditorDashboard',
            name: 'AuditorDashboard',
            component: () =>
                import(
                    '@/stakeholderScreens/auditor/AuditorDashboard.vue'
                ), 
           },
           {
               path: 'auditLogs',
               name: 'AuditorLogs',
               component: () =>
                   import(
                       '@/stakeholderScreens/auditor/AuditorLogs.vue'
                       ),
           },
       ]
    },

    // Bid Evaluation Expert
    {
        path: '/bidEvalExpert',
        name: 'BidEvalExpert',
        props: true,
        component: () =>
            import('@/stakeholderScreens/bidEvalExpert/bidEvalExpertIndex.vue'),
        children: [
            {
                path: 'assignedBids',
                name: 'AssignedBids',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvalExpert/src/AssignedBids.vue'
                    ),
            },


            {
                path: 'ExpertDashboard',
                name: 'ExpertDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvalExpert/ExpertDashboard.vue'
                    ),
            },

            {
                path: 'reviewTechnicalBid',
                name: 'ReviewTechnicalBid',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvalExpert/src/ReviewTechnicalBid.vue'
                    ),
            },

            {
                path: 'reviewFinancialBid',
                props: true,
                name: 'ReviewFinancialBid',
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvalExpert/src/ReviewFinancialBid.vue'
                    ),
            },


            // {
            //     path: 'reviewBid',
            //     name: 'ReviewBid',
            //     component: () =>
            //         import(
            //             '@/stakeholderScreens/bidEvalExpert/src/ReviewBid.vue'
            //         ),
            //     children: [
            //         {
            //             path: 'administrativeEval',
            //             name: 'AdministrativeEval',
            //             component: () =>
            //                 import(
            //                     '@/stakeholderScreens/bidEvalExpert/src/reviewBid/AdministrativeEval.vue'
            //                 ),
            //         },
            //         {
            //             path: 'technicalEval',
            //             name: 'TechnicalEval',
            //             component: () =>
            //                 import(
            //                     '@/stakeholderScreens/bidEvalExpert/src/reviewBid/TechnicalEval.vue'
            //                 ),
            //         },
            //         {
            //             path: 'financialEval',
            //             name: 'FinalcialEval',
            //             component: () =>
            //                 import(
            //                     '@/stakeholderScreens/bidEvalExpert/src/reviewBid/FinancialEval.vue'
            //                 ),
            //         },
            //         {
            //             path: 'performance',
            //             name: 'PerformanceBidEval',
            //             component: () =>
            //                 import(
            //                     '@/stakeholderScreens/bidEvalExpert/src/reviewBid/Performance.vue'
            //                 ),
            //         },
            //         {
            //             path: 'awardCertificate',
            //             name: 'AwardCertificate',
            //             component: () =>
            //                 import(
            //                     '@/stakeholderScreens/bidEvalExpert/src/reviewBid/AwardCertificate.vue'
            //                 ),
            //         },
            //     ],
            // },
        ],
    },






//Shipper

{
    path: '/shipper',
    name: 'ShipperIndex',
    props: true,
    component: () =>
    import('@/stakeholderScreens/shipper/ShipperIndex.vue'),
children: [
        {
            path: 'ActiveOrders',
            name: 'ActiveOrders',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/src/ActiveOrders.vue'),
        },
        {
            path: 'ShippingOrderDetails',
            name: 'ShippingOrderDetails',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/src/ShippingOrderDetails.vue'),
        },

        {
            path: 'NewOrderDetails',
            name: 'NewOrderDetails',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/src/NewOrderDetails.vue'),
        },
        {
            path: 'OrderStatus',
            name: 'OrderStatus',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/src/OrderStatus.vue'),
        },
        {
            path: 'ShippingHistory',
            name: 'ShippingHistory',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/src/History.vue'),
        },
        {
            path: 'NewOrders',
            name: 'NewOrders',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/src/NewOrders.vue'),
        },

        {
            path: 'Notify',
            name: 'Notify',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/src/Notify.vue'),
        },
        {
            path: 'ShipperDashboard',
            name: 'ShipperDashboard',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/ShipperDashboard.vue'),
        },
        {
            path: 'Ports',
            name: 'Ports',
            props: true,
            component: () => import('@/stakeholderScreens/shipper/src/Ports.vue'),
        },
        
       






    ],
},


    // Bid Evaluation Chairman

    // Bid Evaluation Chairman
    {
        path: '/bidEvalChairman',
        name: 'BidEvalChairman',
        props: true,
        component: () =>
            import(
                '@/stakeholderScreens/bidEvaluationChairman/BidEvalChairmanIndex.vue'
            ),
        children: [
            {
                path: 'dashboard',
                name: 'BidEvalChairmanDashboard',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvaluationChairman/BidEvalChairmanDashboard.vue'
                    ),
            },
            {
                path: 'activeTenders',
                name: 'ActiveTendersForChairman',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvaluationChairman/src/ActiveTendersForChairman.vue'
                    ),
            },

            {
                path: 'TenderDetailsForChairman',
                name: 'TenderDetailsForChairman',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvaluationChairman/src/TenderDetailsForChairman.vue'
                    ),
            },
            {
                path: 'pendingAssignments',
                name: 'PendingAssignments',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvaluationChairman/src/PendingAssignments.vue'
                    ),
            },
            {
                path: 'viewAll',
                name: 'ViewAllBids',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvaluationChairman/src/ViewAllBids.vue'
                    ),
            },
            {
                path: 'assignExpert',
                name: 'AssignExpert',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvaluationChairman/src/assignExpert/AssignExperts.vue'
                    ),
            },
            {
                path: 'trackBidStatus',
                name: 'TrackBidStatus',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidEvaluationChairman/src/trackBidStatusMain.vue'
                    ),
                children: [
                    {
                        path: 'status',
                        name: 'bidEvalChairmanBidStatus',
                        props: true,
                        component: () =>
                            import(
                                '@/stakeholderScreens/bidEvaluationChairman/src/trackbidStatus/TrackBidStatus.vue'
                            ),
                    },
                    {
                        path: 'scoredResponses',
                        name: 'ScoredResponses',
                        props: true,
                        component: () =>
                            import(
                                '@/stakeholderScreens/bidEvaluationChairman/src/trackbidStatus/ScoredResponses.vue'
                            ),
                    },
                    {
                        path: 'resultSummary',
                        name: 'ResultSummary',
                        props: true,
                        component: () =>
                            import(
                                '@/stakeholderScreens/bidEvaluationChairman/src/trackbidStatus/ResultSummary.vue'
                            ),
                    },
                    {
                        path: 'evaluationReport',
                        name: 'EvaluationReport',
                        props: true,
                        component: () =>
                            import(
                                '@/stakeholderScreens/bidEvaluationChairman/src/trackbidStatus/EvaluationReport.vue'
                            ),
                    },
                ],
            },
        ],
    },

    //Bidder
    {
        path: '/bidder',
        name: 'BidderIndex',
        props: true,
        component: () => import('@/stakeholderScreens/bidder/BidderIndex.vue'),
        children: [
            {
                path: 'dashboard',
                name: 'BidderDashboard',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/BidderDashboard.vue'),
            },
            {
                path: 'profile',
                name: 'BidderProfile',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/BidderProfile.vue'),
            },
            {
                path: 'submittedBids',
                name: 'SubmittedBids',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/submittedBids.vue'),
            },
            {
                path: 'approvedBids',
                name: 'ApprovedBids',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/ApprovedBids.vue'),
            },
            {
                path: 'bookForFreight',
                name: 'BookForFreight',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/BookForFreight.vue'),
            },
            {
                path: 'bookForSupplier',
                name: 'BookForSupplier',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/BookForSupplier.vue'),
            },
            {
                path: 'bookedForFreightConfirmationScreen',
                name: 'BookedForFreightConfirmationScreen',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/BookedForFreightConfirmationScreen.vue'),
            },
            {
                path: 'bookedForSupplierConfirmationScreen',
                name: 'BookedForSupplierConfirmationScreen',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/BookedForSupplierConfirmationScreen.vue'),
            },
            {
                path: 'submittedBids/bidStatus',
                name: 'BidTrackStatus',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidder/src/BidTrackStatus.vue'
                    ),
            },
            {
                path: 'notifications',
                name: 'Notifications',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/Notifications.vue'),
            },
            {
                path: 'tendersList',
                name: 'TendersList',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/bidder/src/TendersList.vue'),
            },
            {
                path: 'activeTenders',
                name: 'ActiveTendersView',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidder/src/ActiveTendersView.vue'
                    ),
            },
            {
                path: 'submitBid',
                name: 'SubmitBid',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidder/src/SubmitBid.vue'
                    ),
            },
            {
                path: 'tenderDetailsForBidder',
                name: 'TenderDetailsForBidder',
                props: true,
                component: () =>
                    import(
                        '@/stakeholderScreens/bidder/src/TenderDetailsForBidder.vue'
                    ),
            },
        ],
    },

    // International Bidder
    {
        path: '/internationalBidder',
        name: 'InternationalBidderIndex',
        props: true,
        component: () => import('@/stakeholderScreens/internationalBidder/InternationalBidderIndex.vue'),
        children: [
            {
                path: 'dashboard',
                name: 'InternationalBidderDashboard',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/internationalBidder/InternationalBidderDashboard.vue'),
            },
            {
                path: 'profile',
                name: 'InternationalBidderProfile',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/internationalBidder/src/InternationalBidderProfile.vue'),
            },
            {
                path: 'submittedBids',
                name: 'InternationalSubmittedBids',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/internationalBidder/src/InternationalSubmittedBids.vue'),
            },
            // {
            //     path: 'submittedBids/bidStatus',
            //     name: 'BidTrackStatus',
            //     props: true,
            //     component: () =>
            //         import(
            //             '@/stakeholderScreens/internationalBidder/src/BidTrackStatus.vue'
            //             ),
            // },
            {
                path: 'notifications',
                name: 'InternationalNotifications',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/internationalBidder/src/InternationalNotifications.vue'),
            },
            {
                path: 'tendersList',
                name: 'InternationalTendersList',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/internationalBidder/src/InternationalTendersList.vue'),
            },
            // {
            //     path: 'activeTenders',
            //     name: 'ActiveTendersView',
            //     props: true,
            //     component: () =>
            //         import(
            //             '@/stakeholderScreens/bidder/src/ActiveTendersView.vue'
            //             ),
            // },
            // {
            //     path: 'submitBid',
            //     name: 'SubmitBid',
            //     props: true,
            //     component: () =>
            //         import(
            //             '@/stakeholderScreens/bidder/src/SubmitBid.vue'
            //             ),
            // },
            // {
            //     path: 'tenderDetailsForBidder',
            //     name: 'TenderDetailsForBidder',
            //     props: true,
            //     component: () =>
            //         import(
            //             '@/stakeholderScreens/bidder/src/TenderDetailsForBidder.vue'
            //             ),
            // },
        ],
    },

    // Freight Forwarder
    {
        path: '/freight',
        name: 'FreightIndex',
        component: () => import('@/stakeholderScreens/freightForwarder/FreightIndex.vue'),
        children: [
            {
                path: 'freightDashBoard',
                name: 'FreightDashBoard',
                component: () => import('@/stakeholderScreens/freightForwarder/FreightDashBoard.vue')
            },
            {
                path: 'createFreightOrder',
                name: 'CreateFreightOrder',
                component: () => import('@/stakeholderScreens/freightForwarder/src/CreateFreightOrder.vue')
            },
            {
                path: 'modeOfTransport',
                name: 'ModeOfTransport',
                component: () => import('@/stakeholderScreens/freightForwarder/src/ModeOfTransport.vue')
            },
            {
                path: 'offlineDiscussion',
                name: 'OfflineDiscussion',
                component: () => import('@/stakeholderScreens/freightForwarder/src/OfflineDiscussion.vue')
            },
            {
                path: 'pendingFreightRequest',
                name: 'PendingFreightRequest',
                component: () => import('@/stakeholderScreens/freightForwarder/src/PendingFreightRequest.vue')
            },
            {
                path: 'statusOfFreight',
                name: 'StatusOfFreight',
                component: () => import('@/stakeholderScreens/freightForwarder/src/StatusOfFreight.vue')
            },
            {
                path: 'productDeliveryStatus',
                name: 'ProductDeliveryStatus',
                component: () => import('@/stakeholderScreens/freightForwarder/src/ProductDeliveryStatus.vue')
            },
        ],
    },

    //Clearing Agency
    {
        path: '/clearingAgency',
        name: 'ClearingAgencyIndex',
        props: true,
        component: () => import('@/stakeholderScreens/clearingAgency/ClearingAgencyIndex.vue'),
        children: [
            {
                path: 'clearingAgencyDashboard',
                name: 'ClearingAgencyDashboard',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/clearingAgency/ClearingAgencyDashboard.vue'),
            },
            {
                path: 'customClearanceOrders',
                name: 'CustomClearanceOrders',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/clearingAgency/src/CustomClearanceOrders.vue'),
            },
            {
                path: 'allFreightOrders',
                name: 'AllFreightOrders',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/clearingAgency/src/AllFreightOrders.vue'),
            },
            {
                path: 'trackFreightOrders',
                name: 'TrackFreightOrders',
                props: true,
                component: () =>
                    import('@/stakeholderScreens/clearingAgency/src/TrackFreightOrders.vue'),
            },

        ],
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes,
})

export default router
