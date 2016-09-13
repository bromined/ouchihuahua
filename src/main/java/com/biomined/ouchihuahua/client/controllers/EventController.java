package com.biomined.ouchihuahua.client.controllers;

/**
 * Created by IntelliJ IDEA.
 * IUser: stephencole
 * Date: 4/19/13
 * Time: 2:18 PM
 */
public class EventController {

//    private CellList<IPainEvent> cellList;
//
//    protected static String[] labels = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
//
//    public class Header {
//        private final String name;
//
//        public Header(String name) {
//            this.name = name;
//
//        }
//
//        public String getName() {
//            return name;
//        }
//
//    }
//
//    public class Content {
//
//        private final String name;
//
//        public Content(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//    }
//
//    private static class ContentCell implements Cell<Content> {
//
//        @Override
//        public void render(SafeHtmlBuilder safeHtmlBuilder, Content model) {
//            safeHtmlBuilder.appendEscaped(model.getName());
//
//        }
//
//        @Override
//        public boolean canBeSelected(Content model) {
//            return true;
//        }
//
//    }
//
//    private static class HeaderCell implements Cell<Header> {
//
//        @Override
//        public void render(SafeHtmlBuilder safeHtmlBuilder, Header model) {
//            safeHtmlBuilder.appendEscaped(model.getName());
//        }
//
//        @Override
//        public boolean canBeSelected(Header model) {
//            return false;
//        }
//
//    }
//
//    public void init() {
//        //set viewport and other settings for mobile
//        MGWT.applySettings(MGWTSettings.getAppSetting());
//
//        //build animation helper and attach it
//        AnimationHelper animationHelper = new AnimationHelper();
//        RootPanel.get().add(animationHelper);
//
//        //build some UI
//        LayoutPanel layoutPanel = new LayoutPanel();
//        PullPanel pullPanel = new PullPanel();
//
//        BasicCell<IPainEvent> cell = new BasicCell<IPainEvent>() {
//
//            @Override
//            public String getDisplayString(IPainEvent painEvent) {
//                return painEvent.getDisplayString();
//            }
//        };
//
//        cellList = new CellList<IPainEvent>(cell);
//        cellList.setRound(true);
//
//        final List<IPainEvent> IPainEventList = new ArrayList<IPainEvent>();
////        final CellList<Content> cellList = new CellList<Content>(new ContentCell());
//        Button button = new Button("Pain Event");
////
//        layoutPanel.add(button);
//        layoutPanel.add(pullPanel);
//        pullPanel.add(cellList);
////
//        button.addTapHandler(new TapHandler() {
//            @Override
//            public void onTap(TapEvent event) {
////                IPainEventList.add(new IPainEvent("this is new event"));
//                cellList.render(IPainEventList);
//            }
//        });
//
//        cellList.addCellSelectedHandler(new CellSelectedHandler() {
//            @Override
//            public void onCellSelected(CellSelectedEvent cellSelectedEvent) {
//                GWT.log(cellSelectedEvent.toDebugString());
//                cellSelectedEvent.getAssociatedType().toString();
//            }
//        });
////
////        button.addLongTapHandler(new LongTapHandler() {
////            @Override
////            public void onLongTap(LongTapEvent longTapEvent) {
////                GWT.log(longTapEvent.toDebugString());
////            }
////        });
//
//        // animate
//        animationHelper.goTo(layoutPanel, Animation.SLIDE);
//    }
}
